package com.jianlinsheng.myline.Controller;

import com.jianlinsheng.myline.Service.UserServe;

import com.jianlinsheng.myline.pojo.Result;
import com.jianlinsheng.myline.pojo.User;

import com.jianlinsheng.myline.vo.UserLoginVO;
import com.jianlinsheng.myline.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/user")
@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserServe userServe;



    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody  User user) {


        log.info("登陆的信息为:{}",user);


        return Result.success(userServe.login(user));
    }


    //获取详细信息
    @GetMapping("/getInfo")
    public Result<UserVo> getInfo(@RequestParam Integer id) {


        log.info("获取信息的用户为:{}",id);


        UserVo userVo= userServe.getInfo(id);


        return Result.success(userVo);
    }





}
