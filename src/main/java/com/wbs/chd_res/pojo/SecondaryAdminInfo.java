package com.wbs.chd_res.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 二级管理员信息表
 *
 * @author wbs
 * @create 2022-05-02 17:05
 */
@Data  //引入get，set等方法
@AllArgsConstructor //引入全参构造方法
@NoArgsConstructor //引入无参构造方法
@TableName("secondary_admin_info") //MyBatis Plus与数据库表格进行对应
public class SecondaryAdminInfo {
    @TableId(value="secondary_admin_id",type = IdType.AUTO)
    private Integer secondaryAdminId;
    private String secondaryAdminNumber;
    private String secondaryAdminName;
    private String secondaryAdminSex;
    private String secondaryAdminPhone;
    private String secondaryAdminPassword;
    private String secondaryAdminIcon;
    private String secondaryAdminPicture;
}
