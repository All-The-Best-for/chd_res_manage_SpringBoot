package com.wbs.chd_res.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wbs.chd_res.pojo.NowOrder;
import com.wbs.chd_res.pojo.OrderInfo;

import java.util.List;

/**
 * @author wbs
 * @create 2022-05-02 18:38
 */
public interface OrderInfoService extends IService<OrderInfo> {
    void myInsert(Integer orderId, Integer dishId,Integer count);

    List<OrderInfo> getOrderInfos(Integer orderId);

    int deleteOrders(NowOrder theOrder);
}
