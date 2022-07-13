package com.wbs.chd_res.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 解析request请求中的 token口令的工具AuthContextHolder
 * 对token使用的简化，对JwtHelper进行封装
 * @author wbs
 * @create 2022-04-28 19:40
 */
public class AuthContextHolder {
    //从请求头token获取userid
    public static Long getUserIdToken(HttpServletRequest request) {
        //从请求头token
        String token = request.getHeader("token");
        //调用工具类
        Long userId = JwtHelper.getUserId(token);
        return userId;
    }

    //从请求头token获取name
    public static String getUserName(HttpServletRequest request) {
        //从header获取token
        String token = request.getHeader("token");
        //jwt从token获取username
        String userName = JwtHelper.getUserName(token);
        return userName;
    }
}
