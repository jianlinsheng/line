package com.jianlinsheng.myline.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data

@Repository
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int id;

    private String username;
    private String password;
    private String image;
    private String phone;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private int createUser;
    private int updateUser;


    //the status for user
    private int status;



}
