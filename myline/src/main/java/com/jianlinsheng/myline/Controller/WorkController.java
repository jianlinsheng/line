package com.jianlinsheng.myline.Controller;


import com.jianlinsheng.myline.Service.WorkServe;
import com.jianlinsheng.myline.pojo.Result;
import com.jianlinsheng.myline.pojo.Work;
import com.jianlinsheng.myline.vo.ediWorkVo;
import com.jianlinsheng.myline.vo.workVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/work")
@RestController
@CrossOrigin(origins = "*")
public class WorkController {


    @Autowired
    private WorkServe workServe;



    @GetMapping("/getById")
    public Result<ediWorkVo> getWorkById(@RequestParam int workId) {

        log.info("TOGetWorkById:{}",workId);
       ediWorkVo ediWorkVo = workServe.getWorkById(workId);
        return Result.success(ediWorkVo);
    }










}
