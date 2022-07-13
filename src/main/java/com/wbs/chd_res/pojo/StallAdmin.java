package com.wbs.chd_res.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 档口-管理员对应表
 *
 * @author wbs
 * @create 2022-05-02 17:08
 */
@Data  //引入get，set等方法
@AllArgsConstructor //引入全参构造方法
@NoArgsConstructor //引入无参构造方法
@TableName("stall_admin") //MyBatis Plus与数据库表格进行对应
public class StallAdmin {
    @TableId(value="stall_id")
    private Integer stallId;
    @TableId(value="SecondaryAdmin_id")
    private Integer SecondaryAdminId;
}
