package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.RestaurantInfoMapper;
import com.wbs.chd_res.pojo.RestaurantInfo;
import com.wbs.chd_res.service.RestaurantInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbs
 * @create 2022-05-02 18:49
 */
@Service("restaurantInfoServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class RestaurantInfoServiceImpl
        extends ServiceImpl<RestaurantInfoMapper, RestaurantInfo>
        implements RestaurantInfoService {
}
