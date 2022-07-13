package com.wbs.chd_res.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 这是用来放回订单信息的实体类
 * @author wbs
 * @create 2022-05-27 15:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReOrder {
    private Integer isPay;
    private Float orderAmount;
    private Integer orderId;
    private Date orderTime;
    private Integer userId;
    private Integer stallId;
    private List<OrderInfo> orderInfo;
}
