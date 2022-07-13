package com.wbs.chd_res.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wbs.chd_res.pojo.LoginForm;
import com.wbs.chd_res.pojo.SecondaryAdminInfo;

/**
 * @author wbs
 * @create 2022-05-02 18:50
 */
public interface SecondaryAdminInfoService extends IService<SecondaryAdminInfo> {
    SecondaryAdminInfo login(LoginForm loginForm);

    SecondaryAdminInfo getSecondaryAdminById(Long userId);
}
