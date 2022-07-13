package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.DishInfoMapper;
import com.wbs.chd_res.pojo.DishInfo;
import com.wbs.chd_res.service.DishInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbs
 * @create 2022-05-02 18:34
 */
@Service("dishInfoServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class DishInfoServiceImpl extends ServiceImpl<DishInfoMapper,DishInfo> implements DishInfoService {

    @Autowired
    DishInfoMapper dishInfoMapper;

//    根据stallId查询stall对应的dish
    @Override
    public DishInfo getDish(Integer dishId) {
        QueryWrapper<DishInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("dish_id", dishId);

        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public List<String> getSortName(Integer stall_id) {
        List<String> sortsByStall = dishInfoMapper.getSortsByStall(stall_id);
        return sortsByStall;
    }

//    根据stallId和stall_sort查询数据
    @Override
    public List<DishInfo> getGoods( String next) {

        QueryWrapper<DishInfo> queryWrapper=new QueryWrapper<>();
//        queryWrapper.eq("dish_id", dishId);
        queryWrapper.eq("dish_sort", next);

        List<DishInfo> dishInfos = baseMapper.selectList(queryWrapper);

        return dishInfos;
    }
}
