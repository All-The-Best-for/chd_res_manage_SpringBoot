package com.wbs.chd_res.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 充值流水-用户对应表
 *
 * @author wbs
 * @create 2022-05-02 16:53
 */
@Data  //引入get，set等方法
@AllArgsConstructor //引入全参构造方法
@NoArgsConstructor //引入无参构造方法
@TableName("recharge_user") //MyBatis Plus与数据库表格进行对应
public class RechargeUser {
    @TableId(value="user_id")
    private Integer userId;
    @TableId(value="recharge_id")
    private Integer rechargeId;
}
