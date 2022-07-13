package com.wbs.chd_res.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 超级管理员信息表
 *
 * @author wbs
 * @create 2022-05-02 17:24
 */
@Data  //引入get，set等方法
@AllArgsConstructor //引入全参构造方法
@NoArgsConstructor //引入无参构造方法
@TableName("super_admin_info") //MyBatis Plus与数据库表格进行对应
public class SuperAdminInfo {
    @TableId(value="super_id",type = IdType.AUTO)
    private Integer superId;
    private String superNumber;
    private String superName;
    private String superSex;
    private String superPhone;
    private String superPassword;
    private String superIcon;
    private String superPicture;
}
