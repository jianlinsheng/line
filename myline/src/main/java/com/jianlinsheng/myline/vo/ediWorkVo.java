package com.jianlinsheng.myline.vo;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;
@Data
@Repository
public class ediWorkVo implements java.io.Serializable {
    private Integer id;
    private Integer userId;
    private String context;
    private String username;
    private String title;
    private String createTime;
    private String updateTime;
    private List<String> tags;
    private String preview;
}
