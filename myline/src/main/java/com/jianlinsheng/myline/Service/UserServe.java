package com.jianlinsheng.myline.Service;


import com.jianlinsheng.myline.pojo.User;
import com.jianlinsheng.myline.vo.UserLoginVO;
import com.jianlinsheng.myline.vo.UserVo;

public interface UserServe {

     UserLoginVO login(User user);
     //获取详细信息
     UserVo getInfo(Integer id);
}
