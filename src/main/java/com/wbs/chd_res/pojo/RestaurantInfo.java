package com.wbs.chd_res.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 餐厅信息表
 *
 * @author wbs
 * @create 2022-05-02 17:01
 */
@Data  //引入get，set等方法
@AllArgsConstructor //引入全参构造方法
@NoArgsConstructor //引入无参构造方法
@TableName("restaurant_info") //MyBatis Plus与数据库表格进行对应
public class RestaurantInfo {
    @TableId(value="res_id",type = IdType.AUTO)
    private Integer resId;
    private String resName;
    private Double resAccount;  //餐厅盈利
    private Float resStar;
    private Integer resAmount;  //餐厅销量
}
