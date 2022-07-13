package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.SecondaryAdminInfoMapper;
import com.wbs.chd_res.pojo.LoginForm;
import com.wbs.chd_res.pojo.SecondaryAdminInfo;
import com.wbs.chd_res.service.SecondaryAdminInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbs
 * @create 2022-05-02 18:50
 */
@Service("secondaryAdminInfoServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class SecondaryAdminInfoServiceImpl
        extends ServiceImpl<SecondaryAdminInfoMapper, SecondaryAdminInfo>
        implements SecondaryAdminInfoService {
    @Override
    public SecondaryAdminInfo login(LoginForm loginForm) {
        QueryWrapper<SecondaryAdminInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("secondary_admin_name", loginForm.getName());
        queryWrapper.eq("secondary_admin_password",loginForm.getPwd());

//        可以加入MD5进行加密比对
//        queryWrapper.eq("top_admin_password", MD5.encrypt(loginForm.getPassword()));

        SecondaryAdminInfo secondaryAdminInfo = baseMapper.selectOne(queryWrapper);
        return secondaryAdminInfo;
    }

    @Override
    public SecondaryAdminInfo getSecondaryAdminById(Long userId) {
        QueryWrapper<SecondaryAdminInfo> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("secondary_admin_id", userId);

        return baseMapper.selectOne(queryWrapper);
    }
}
