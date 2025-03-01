package com.jianlinsheng.myline.mapper;


import com.jianlinsheng.myline.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User is_exist(User user);

    User getById(Integer id);

    String getUsername(int id);
}
