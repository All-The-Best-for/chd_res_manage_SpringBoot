package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.OrderInfoMapper;
import com.wbs.chd_res.pojo.NowOrder;
import com.wbs.chd_res.pojo.OrderInfo;
import com.wbs.chd_res.pojo.OrderUser;
import com.wbs.chd_res.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbs
 * @create 2022-05-02 18:39
 */
@Service("orderInfoServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public void myInsert(Integer orderId, Integer dishId,Integer count) {
        orderInfoMapper.myInsert(orderId, dishId,count);
    }

    @Override
    public List<OrderInfo> getOrderInfos(Integer orderId) {
        QueryWrapper<OrderInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);

        List<OrderInfo> orderInfos = baseMapper.selectList(queryWrapper);
        return orderInfos;
    }

    @Override
    public int deleteOrders(NowOrder theOrder) {
        QueryWrapper<OrderInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("order_id", theOrder.getOrderId());

        int delete = baseMapper.delete(queryWrapper);
        return delete;
    }
}
