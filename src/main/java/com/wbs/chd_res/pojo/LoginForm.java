package com.wbs.chd_res.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录信息表
 * 为了接收登录信息更加简便，将一些登录信息封装成一个类来处理
 * 不与数据库中的表格对应
 *
 * @author wbs
 * @create 2022-05-02 17:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {
    private String name;
    private String pwd;
}
