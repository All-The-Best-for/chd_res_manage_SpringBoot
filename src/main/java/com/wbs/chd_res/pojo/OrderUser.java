package com.wbs.chd_res.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 订单-用户对应表
 *
 * @author wbs
 * @create 2022-05-02 16:48
 */
@Data  //引入get，set等方法
@AllArgsConstructor //引入全参构造方法
@NoArgsConstructor //引入无参构造方法
@TableName("order_user") //MyBatis Plus与数据库表格进行对应
public class OrderUser {
    @TableId(value="order_id")
    private Integer orderId;
    private Integer userId;
    private Float orderAmount;
    private Integer stallId;
//    订单状态:1已完成、2未支付、3待取餐、4待评价、5已取消
    private Integer isPay;
    private Integer isAccept;
    private Date orderTime;
}
