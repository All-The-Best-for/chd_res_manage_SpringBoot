package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.TopAdminInfoMapper;
import com.wbs.chd_res.pojo.LoginForm;
import com.wbs.chd_res.pojo.TopAdminInfo;
import com.wbs.chd_res.service.TopAdminInfoService;
import com.wbs.chd_res.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbs
 * @create 2022-05-02 19:00
 */
@Service("topAdminInfoServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class TopAdminInfoServiceImpl
        extends ServiceImpl<TopAdminInfoMapper, TopAdminInfo>
        implements TopAdminInfoService {
    @Override
    public TopAdminInfo login(LoginForm loginForm) {
        QueryWrapper<TopAdminInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("top_admin_name", loginForm.getName());
        queryWrapper.eq("top_admin_password",loginForm.getPwd());

//        可以加入MD5进行加密比对
//        queryWrapper.eq("top_admin_password", MD5.encrypt(loginForm.getPassword()));

        TopAdminInfo topAdminInfo = baseMapper.selectOne(queryWrapper);
        return topAdminInfo;
    }

    @Override
    public TopAdminInfo getTopAdminById(Long userId) {
        QueryWrapper<TopAdminInfo> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("top_admin_id", userId);

        return baseMapper.selectOne(queryWrapper);
    }
}
