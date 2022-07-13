package com.wbs.chd_res.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wbs.chd_res.pojo.DishInfo;

import java.util.List;

/**
 * @author wbs
 * @create 2022-05-02 18:14
 */
public interface DishInfoService extends IService<DishInfo> {
    DishInfo getDish(Integer dishId);

    List<String> getSortName(Integer stall_id);

    List<DishInfo> getGoods( String next);
}
