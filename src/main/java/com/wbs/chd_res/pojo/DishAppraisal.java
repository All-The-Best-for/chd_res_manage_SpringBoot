package com.wbs.chd_res.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 餐品评价表
 *
 * @author wbs
 * @create 2022-05-02 16:18
 */
@Data  //引入get，set等方法
@AllArgsConstructor //引入全参构造方法
@NoArgsConstructor //引入无参构造方法
@TableName("dish_appraisal") //MyBatis Plus与数据库表格进行对应
public class DishAppraisal {
    @TableId(value="user_id")
    private Integer userId;
    @TableId(value="dish_id")
    private Integer dishId;
    private String appraisalText;
    private Float agree;
    private Integer negative;
    private Date appraisalTime;
}
