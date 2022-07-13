package com.wbs.chd_res.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wbs.chd_res.pojo.LoginForm;
import com.wbs.chd_res.pojo.TopAdminInfo;

/**
 * @author wbs
 * @create 2022-05-02 19:00
 */
public interface TopAdminInfoService extends IService<TopAdminInfo> {

    TopAdminInfo login(LoginForm loginForm);

    TopAdminInfo getTopAdminById(Long userId);
}
