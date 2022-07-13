package com.wbs.chd_res.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 订单信息表
 *
 * @author wbs
 * @create 2022-05-02 16:46
 */
@Data  //引入get，set等方法
@AllArgsConstructor //引入全参构造方法
@NoArgsConstructor //引入无参构造方法
@TableName("order_info") //MyBatis Plus与数据库表格进行对应
public class OrderInfo {
    @TableId(value="order_id")
    private Integer orderId;
    private Integer orderDish;
    private Integer count;
}
