package com.jianlinsheng.myline.vo;

import com.jianlinsheng.myline.pojo.Work;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



@Repository
@Data
public class workVo implements Serializable {


    private Integer id;
    private Integer userId;
    private String username;
    private String title;
    private String createTime;
    private String updateTime;
    private List<String> tags;
    private String strTags;
    private String preview;


}
