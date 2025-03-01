package com.jianlinsheng.myline.Utils;

import com.jianlinsheng.myline.pojo.ToDBWork;
import com.jianlinsheng.myline.pojo.Work;
import com.jianlinsheng.myline.vo.ediWorkVo;
import com.jianlinsheng.myline.vo.workVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Slf4j
public class Utils {


    public static void TODBWorkTransformToWorkVo(ToDBWork todbWork, workVo workVo, List<workVo> works,String username) {

        log.info("TODBWorkTransformToWorkVo:{}", todbWork);
        //处理tags datetime
        TODBWorkTransformToWorkVo(todbWork, workVo, username);
        works.add(workVo);//将转换好的work存在对应list中


    }

    public static void TODBWorkTransformToWorkVo(ToDBWork toDBWork, workVo workVo,String username) {
        String tagString = toDBWork.getTags();
        String[] tags = tagString.split(",");
        BeanUtils.copyProperties(toDBWork, workVo);
        workVo.setTags(List.of(tags));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String createStr = toDBWork.getCreateTime().format(formatter);
        workVo.setCreateTime(createStr);
        String updateStr = toDBWork.getUpdateTime().format(formatter);
        workVo.setUpdateTime(updateStr);
        workVo.setUsername(username);

    }public static void TODBWorkTransformToWorkVo(ToDBWork toDBWork, ediWorkVo ediWorkVo, String username) {
        String tagString = toDBWork.getTags();
        String[] tags = tagString.split(",");
        BeanUtils.copyProperties(toDBWork, ediWorkVo);
        //处理tag
        ediWorkVo.setTags(List.of(tags));

        //格式化时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String createStr = toDBWork.getCreateTime().format(formatter);
        ediWorkVo.setCreateTime(createStr);
        String updateStr = toDBWork.getUpdateTime().format(formatter);
        ediWorkVo.setUpdateTime(updateStr);
        ediWorkVo.setUsername(username);

    }
}
