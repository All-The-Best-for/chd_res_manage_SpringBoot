package com.wbs.chd_res.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wbs.chd_res.pojo.LoginForm;
import com.wbs.chd_res.pojo.SuperAdminInfo;

/**
 * @author wbs
 * @create 2022-05-02 18:58
 */
public interface SuperAdminInfoService extends IService<SuperAdminInfo> {

    SuperAdminInfo login(LoginForm loginForm);

    SuperAdminInfo getSuperAdminById(Long userId);
}
