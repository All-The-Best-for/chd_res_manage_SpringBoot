package com.wbs.chd_res.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 顶级管理员信息表
 *
 * @author wbs
 * @create 2022-05-02 17:26
 */
@Data  //引入get，set等方法
@AllArgsConstructor //引入全参构造方法
@NoArgsConstructor //引入无参构造方法
@TableName("top_admin_info") //MyBatis Plus与数据库表格进行对应
public class TopAdminInfo {
    @TableId(value="top_admin_id",type = IdType.AUTO)
    private Integer topAdminId;
    private String topAdminNumber;
    private String topAdminName;
    private String topAdminSex;
    private String topAdminPhone;
    private String topAdminPassword;
    private String topAdminIcon;
    private String topAdminPicture;
}
