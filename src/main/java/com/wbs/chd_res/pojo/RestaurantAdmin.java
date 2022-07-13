package com.wbs.chd_res.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 餐厅-管理员对应表
 *
 * @author wbs
 * @create 2022-05-02 16:14
 */
@Data  //引入get，set等方法
@AllArgsConstructor //引入全参构造方法
@NoArgsConstructor //引入无参构造方法
@TableName("restaurant_admin") //MyBatis Plus与数据库表格进行对应
public class RestaurantAdmin {
//    主键自动判断数据类型
    @TableId(value="restaurant_id")
    private Integer restaurantId;
    @TableId(value="top_admin_id")
//    可能有错误
    private Integer topAdminId;
}
