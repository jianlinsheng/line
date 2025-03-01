package com.jianlinsheng.myline.mapper;


import com.jianlinsheng.myline.pojo.ToDBWork;
import com.jianlinsheng.myline.pojo.Work;
import com.jianlinsheng.myline.vo.workVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkMapper {
    List<ToDBWork> getById(Integer id);

    ToDBWork getByWorkId(Integer id);

    Integer getUserID(int id);
}
