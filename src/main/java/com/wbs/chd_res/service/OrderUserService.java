package com.wbs.chd_res.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wbs.chd_res.pojo.NowOrder;
import com.wbs.chd_res.pojo.OrderUser;

import java.util.Date;
import java.util.List;

/**
 * @author wbs
 * @create 2022-05-02 18:40
 */
public interface OrderUserService extends IService<OrderUser> {
    void myInsert(Integer userId, Integer orderId, Integer orderAmount, Integer stallId, int is_pay, int is_accept, Date orderTime);

    OrderUser getNowOrder(Integer orderId);

    List<OrderUser> getOrders(Integer userId);

    int deleteOrder(NowOrder theOrder);

    Boolean updateIsPay(Integer orderId, int isPay);
}
