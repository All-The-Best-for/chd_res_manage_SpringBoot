package com.wbs.chd_res.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wbs.chd_res.pojo.RecommendationStall;

import java.util.List;

/**
 * @author wbs
 * @create 2022-05-04 8:50
 */
public interface RecommendationStallService extends IService<RecommendationStall> {
    void computedRecommendation();

    List<RecommendationStall> getAll();
}
