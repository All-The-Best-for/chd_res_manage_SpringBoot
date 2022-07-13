package com.wbs.chd_res.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wbs.chd_res.pojo.StallInfo;

import java.util.List;

/**
 * @author wbs
 * @create 2022-05-02 18:55
 */
public interface StallInfoService extends IService<StallInfo> {
    List<StallInfo> getStalls();
}
