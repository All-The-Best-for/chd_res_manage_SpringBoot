package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.StallDishMapper;
import com.wbs.chd_res.pojo.StallDish;
import com.wbs.chd_res.service.StallDishService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbs
 * @create 2022-05-02 18:54
 */
@Service("stallDishServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class StallDishServiceImpl
        extends ServiceImpl<StallDishMapper, StallDish>
        implements StallDishService {
    @Override
    public List<StallDish> getDishByDishIds(Integer stallId) {
        QueryWrapper<StallDish> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("distinct stall_id").eq("stall_id", stallId);
//        baseMapper.selectList(queryWrapper);
        return baseMapper.selectList(queryWrapper);
//        return  stallDishes;
    }
}
