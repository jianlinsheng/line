package com.jianlinsheng.myline.Service.Iml;


import com.jianlinsheng.myline.Service.WorkServe;
import com.jianlinsheng.myline.Utils.Utils;
import com.jianlinsheng.myline.mapper.UserMapper;
import com.jianlinsheng.myline.mapper.WorkMapper;
import com.jianlinsheng.myline.pojo.ToDBWork;
import com.jianlinsheng.myline.pojo.Work;
import com.jianlinsheng.myline.vo.ediWorkVo;
import com.jianlinsheng.myline.vo.workVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class WorkServeIml implements WorkServe {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private WorkMapper workMapper;


    @Override
    public ediWorkVo getWorkById(int id) {
       ToDBWork toDBWork = workMapper.getByWorkId(id);
       Integer userId = workMapper.getUserID(id);
        String username = userMapper.getUsername(userId);

        ediWorkVo ediWorkVo = new ediWorkVo();
        Utils.TODBWorkTransformToWorkVo(toDBWork, ediWorkVo ,username);




        return ediWorkVo;
    }
}
