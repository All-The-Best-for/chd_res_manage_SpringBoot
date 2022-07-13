package com.wbs.chd_res.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wbs.chd_res.pojo.StallDish;

import java.util.List;

/**
 * @author wbs
 * @create 2022-05-02 18:54
 */
public interface StallDishService extends IService<StallDish> {
    List<StallDish> getDishByDishIds(Integer stallId);
}
