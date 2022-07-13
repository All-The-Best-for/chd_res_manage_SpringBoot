package com.wbs.chd_res.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wbs.chd_res.pojo.LoginForm;
import com.wbs.chd_res.pojo.UserInfo;

/**
 * @author wbs
 * @create 2022-05-02 19:01
 */
public interface UserInfoService extends IService<UserInfo> {

    UserInfo login(LoginForm loginForm);
}
