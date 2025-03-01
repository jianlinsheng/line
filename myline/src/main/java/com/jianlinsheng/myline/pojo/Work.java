package com.jianlinsheng.myline.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
@Data
public class Work implements java.io.Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer userId;
    private String username;
    private String title;
    private String context;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private List<String> tags;
    private String preview;






}
