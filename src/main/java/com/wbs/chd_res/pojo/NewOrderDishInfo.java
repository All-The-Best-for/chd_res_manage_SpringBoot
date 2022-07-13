package com.wbs.chd_res.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 这个类和DihsInfo唯一的区别在于多了一个count属性
 * 专门用来接收订单中的餐品对象
 *
 * @author wbs
 * @create 2022-05-05 9:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOrderDishInfo {
    private Integer dishId;
    private String dishName;
    private Float dishPrice;
    private String dishSort;
    private Integer dishSales;
    private Integer dishMaterial1;
    private Integer dishMaterial2;
    private Integer dishMaterial3;
    private String dishIcon;
    private String dishPicture1;
    private String dishPicture2;
    private String dishPicture3;
    private Float dishStar;
    private Float oldPrice;
    private String dishText;
    private Integer count;
}
