package com.jianlinsheng.myline.Service.Iml;


import com.jianlinsheng.myline.Service.UserServe;
import com.jianlinsheng.myline.Utils.JwtUtil;
import com.jianlinsheng.myline.Utils.Utils;
import com.jianlinsheng.myline.constant.JwtClaimsConstant;
import com.jianlinsheng.myline.constant.MessageConstant;
import com.jianlinsheng.myline.exception.AccountNotFoundException;
import com.jianlinsheng.myline.exception.PasswordErrorException;
import com.jianlinsheng.myline.mapper.UserMapper;
import com.jianlinsheng.myline.mapper.WorkMapper;
import com.jianlinsheng.myline.pojo.ToDBWork;
import com.jianlinsheng.myline.pojo.User;
import com.jianlinsheng.myline.pojo.Work;
import com.jianlinsheng.myline.vo.UserLoginVO;
import com.jianlinsheng.myline.vo.UserVo;
import com.jianlinsheng.myline.vo.workVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jianlinsheng.myline.property.jwtProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserServeIml implements UserServe {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WorkMapper workMapper;
    @Autowired
    private jwtProperty jwtProperty;


    //登录
    @Override
    public UserLoginVO login(User user) {

        //1 查询username是否存在
        User user1 = userMapper.is_exist(user);
        log.info("UserInfo:{}", user1);
        if (user1==null){
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);

        }
        //2判断密码是否正确

        if (!user1.getPassword().equals(user.getPassword())){
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        UserLoginVO userLoginVO = new UserLoginVO();//创建vo对象
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user1.getId());
        //获得token
        String jwt = JwtUtil.createJWT(jwtProperty.getAdminSecretKey(), jwtProperty.getAdminTtl(), claims);

        //封装
        userLoginVO.setToken(jwt);
        userLoginVO.setId(user1.getId());

        return userLoginVO;


    }
    //获取详细信息
    @Override
    public UserVo getInfo(Integer id) {


        //获取数据库信息
        User user = userMapper.getById(id);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        List<ToDBWork> DBworks = workMapper.getById(id);
        List<workVo> works = new ArrayList<>();

       DBworks.forEach(dbwork -> Utils.TODBWorkTransformToWorkVo(dbwork,new workVo(),works ,user.getUsername()));
       userVo.setPreworks(works);

        return userVo;
    }
}
