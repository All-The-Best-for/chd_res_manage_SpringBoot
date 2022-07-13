package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.UserInfoMapper;
import com.wbs.chd_res.pojo.LoginForm;
import com.wbs.chd_res.pojo.SuperAdminInfo;
import com.wbs.chd_res.pojo.UserInfo;
import com.wbs.chd_res.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbs
 * @create 2022-05-02 19:01
 */
@Service("userInfoServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class UserInfoServiceImpl
        extends ServiceImpl<UserInfoMapper, UserInfo>
        implements UserInfoService {
    @Override
    public UserInfo login(LoginForm loginForm) {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_number", loginForm.getName());
        queryWrapper.eq("user_password",loginForm.getPwd());
//        可以加入MD5进行加密比对
//        queryWrapper.eq("top_admin_password", MD5.encrypt(loginForm.getPassword()));

        UserInfo userInfo = baseMapper.selectOne(queryWrapper);
        return userInfo;
    }
}
