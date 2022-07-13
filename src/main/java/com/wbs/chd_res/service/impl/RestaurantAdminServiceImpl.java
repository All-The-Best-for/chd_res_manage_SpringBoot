package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.RestaurantAdminMapper;
import com.wbs.chd_res.pojo.RestaurantAdmin;
import com.wbs.chd_res.service.RestaurantAdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbs
 * @create 2022-05-02 18:47
 */
@Service("restaurantAdminServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class RestaurantAdminServiceImpl
        extends ServiceImpl<RestaurantAdminMapper, RestaurantAdmin>
        implements RestaurantAdminService {
}
