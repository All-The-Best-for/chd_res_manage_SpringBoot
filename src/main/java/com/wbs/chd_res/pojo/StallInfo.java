package com.wbs.chd_res.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 档口信息表
 *
 * @author wbs
 * @create 2022-05-02 17:19
 */
@Data  //引入get，set等方法
@AllArgsConstructor //引入全参构造方法
@NoArgsConstructor //引入无参构造方法
@TableName("stall_info") //MyBatis Plus与数据库表格进行对应
public class StallInfo {
    @TableId(value="stall_id",type = IdType.AUTO)
    private Integer stallId;
    private String stallName;
    private Double stallAccount;  //档口盈利
    private Integer stallRestaurant;
    private String stallText;
    private String stallIcon;
    private String stallPicture1;
    private String stallPicture2;
    private String stallPicture3;
    private Float stallStar;
    private Integer amount;
    private Integer boxFee;
    private String resAddress;
    private Integer dayAmount;
    private Integer isWork;
}
