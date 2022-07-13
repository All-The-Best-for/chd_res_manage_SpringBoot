package com.wbs.chd_res.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 档口-餐品对应表
 *
 * @author wbs
 * @create 2022-05-02 17:15
 */
@Data  //引入get，set等方法
@AllArgsConstructor //引入全参构造方法
@NoArgsConstructor //引入无参构造方法
@TableName("stall_dish") //MyBatis Plus与数据库表格进行对应
public class StallDish {
    @TableId(value="stall_id")
    private Integer stallId;
    @TableId(value="dish_id")
    private Integer dishId;
    @TableId(value="period")
    private Integer period;     //上架时段：1早2中3晚
    private Integer ifStock;    //是否上架
    private Integer amount;     //本档口本餐品剩余数量
}
