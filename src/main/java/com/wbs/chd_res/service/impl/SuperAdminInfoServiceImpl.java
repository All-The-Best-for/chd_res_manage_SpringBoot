package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.SuperAdminInfoMapper;
import com.wbs.chd_res.pojo.LoginForm;
import com.wbs.chd_res.pojo.SuperAdminInfo;
import com.wbs.chd_res.service.SuperAdminInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbs
 * @create 2022-05-02 18:58
 */
@Service("superAdminInfoServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class SuperAdminInfoServiceImpl
        extends ServiceImpl<SuperAdminInfoMapper, SuperAdminInfo>
        implements SuperAdminInfoService {

    @Override
    public SuperAdminInfo login(LoginForm loginForm) {
        QueryWrapper<SuperAdminInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("super_name", loginForm.getName());
        queryWrapper.eq("super_password",loginForm.getPwd());
//        可以加入MD5进行加密比对
//        queryWrapper.eq("top_admin_password", MD5.encrypt(loginForm.getPassword()));

        SuperAdminInfo superAdminInfo = baseMapper.selectOne(queryWrapper);
        return superAdminInfo;
    }

    @Override
    public SuperAdminInfo getSuperAdminById(Long userId) {
        QueryWrapper<SuperAdminInfo> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("super_id", userId);

        return baseMapper.selectOne(queryWrapper);
    }
}
