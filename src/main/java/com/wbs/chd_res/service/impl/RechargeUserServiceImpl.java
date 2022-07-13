package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.RechargeUserMapper;
import com.wbs.chd_res.pojo.RechargeUser;
import com.wbs.chd_res.service.RechargeUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbs
 * @create 2022-05-02 18:43
 */
@Service("rechargeUserServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class RechargeUserServiceImpl
        extends ServiceImpl<RechargeUserMapper, RechargeUser>
        implements RechargeUserService {
}
