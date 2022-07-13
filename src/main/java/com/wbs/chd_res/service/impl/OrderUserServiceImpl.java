package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.OrderUserMapper;
import com.wbs.chd_res.pojo.NowOrder;
import com.wbs.chd_res.pojo.OrderUser;
import com.wbs.chd_res.service.OrderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author wbs
 * @create 2022-05-02 18:40
 */
@Service("orderUserServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class OrderUserServiceImpl
        extends ServiceImpl<OrderUserMapper, OrderUser>
        implements OrderUserService {

    @Autowired
    private OrderUserMapper orderUserMapper;

    @Override
    public void myInsert(Integer userId, Integer orderId, Integer orderAmount, Integer stallId, int is_pay, int is_accept, Date orderTime) {
        orderUserMapper.myInsert(
                userId,
                orderId,
                orderAmount,
                stallId,
                new Integer(is_pay),
                new Integer(is_accept),
                orderTime);
    }

//    根据订单id获取一个账单信息
    @Override
    public OrderUser getNowOrder(Integer orderId) {
        QueryWrapper<OrderUser> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("order_Id", orderId);

        OrderUser orderUser = baseMapper.selectOne(queryWrapper);
        return orderUser;
    }

//    根据用户id获取订单列表
    @Override
    public List<OrderUser> getOrders(Integer userId) {
        QueryWrapper<OrderUser> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);

        List<OrderUser> orderUsers = baseMapper.selectList(queryWrapper);
        return orderUsers;
    }

    @Override
    public int deleteOrder(NowOrder theOrder) {
        QueryWrapper<OrderUser> orderUserQueryWrapper=new QueryWrapper<>();
        orderUserQueryWrapper.eq("order_id", theOrder.getOrderId());

        int delete = baseMapper.delete(orderUserQueryWrapper);
        return delete;
    }

    @Override
    public Boolean updateIsPay(Integer orderId, int isPay) {
        QueryWrapper<OrderUser> orderUserQueryWrapper=new QueryWrapper<>();
        orderUserQueryWrapper.eq("order_id", orderId);

        Boolean aBoolean = orderUserMapper.updateIsPayById(isPay, orderId);
        return aBoolean;
    }


}
