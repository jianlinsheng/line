package com.jianlinsheng.myline.Service;

import com.jianlinsheng.myline.pojo.Work;
import com.jianlinsheng.myline.vo.ediWorkVo;
import com.jianlinsheng.myline.vo.workVo;

public interface WorkServe {
    ediWorkVo getWorkById(int id);
}
