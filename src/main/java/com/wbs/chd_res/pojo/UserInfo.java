package com.wbs.chd_res.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息表
 *
 * @author wbs
 * @create 2022-05-02 17:28
 */
@Data  //引入get，set等方法
@AllArgsConstructor //引入全参构造方法
@NoArgsConstructor //引入无参构造方法
@TableName("user_info") //MyBatis Plus与数据库表格进行对应
public class UserInfo {
    @TableId(value="user_id",type = IdType.AUTO)
    private Integer userId;
    private String userNumber;
    private String userName;
    private String userSex;
    private String userPhone;
    private String userPassword;
    private Float userAccount;      //账户余额
    private String userIcon;
    private String userPicture;
}
