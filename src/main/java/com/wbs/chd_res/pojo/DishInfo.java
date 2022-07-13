package com.wbs.chd_res.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 餐品信息表
 *
 * @author wbs
 * @create 2022-05-02 16:36
 */
@Data  //引入get，set等方法
@AllArgsConstructor //引入全参构造方法
@NoArgsConstructor //引入无参构造方法
@TableName("dish_info") //MyBatis Plus与数据库表格进行对应
public class DishInfo {
    @TableId(value="dish_id",type = IdType.AUTO)
    private Integer dishId;
    private String dishName;
    private Float dishPrice;
    private String dishSort;
    private Integer dishSales;
    private String dishIcon;
    private String dishPicture1;
    private Float dishStar;
    private Float oldPrice;
    private String dishText;
}
