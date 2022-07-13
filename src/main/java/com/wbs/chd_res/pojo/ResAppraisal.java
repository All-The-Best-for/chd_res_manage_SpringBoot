package com.wbs.chd_res.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 餐厅-评价对应表
 *
 * @author wbs
 * @create 2022-05-02 16:55
 */
@Data  //引入get，set等方法
@AllArgsConstructor //引入全参构造方法
@NoArgsConstructor //引入无参构造方法
@TableName("res_appraisal") //MyBatis Plus与数据库表格进行对应
public class ResAppraisal {
    @TableId(value="res_id")
    private Integer resId;
    @TableId(value="user_id")
    private Integer userId;
    private String appraisalText;
    private Integer agree;
    private Integer negative;
    private Timestamp appraisalTime;
}
