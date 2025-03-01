package com.jianlinsheng.myline.vo;

import com.jianlinsheng.myline.pojo.Work;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data

@Repository
public class UserVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int id;

    private String username;
    private String password;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private int createUser;
    private int updateUser;
    private String image;
    private String phone;

    private List<workVo> Preworks;



    //the status for user
    private int status;



}