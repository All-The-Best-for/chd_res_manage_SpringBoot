package com.wbs.chd_res.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 专门用来接收前端数据，生成订单信息的类
 *
 * @author wbs
 * @create 2022-05-04 16:34
 */
@Data
public class NewOrder {
    private Integer userId;
//    private Integer stallId;
    private Integer orderId;
    private Float orderAmount;
    private Date orderTime;
    private List<NewOrderDishInfo> orderDishs;
    private StallInfo stallInfo;
}