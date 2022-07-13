package com.wbs.chd_res.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 热门推荐店铺表
 *
 * @author wbs
 * @create 2022-05-04 8:44
 */
@Data  //引入get，set等方法
@AllArgsConstructor //引入全参构造方法
@NoArgsConstructor //引入无参构造方法
@TableName("recommendation_stall") //MyBatis Plus与数据库表格进行对应
public class RecommendationStall {
    @TableId(value="stall_id")
    private Integer stallId;
    private  Integer isAdmin;
}
