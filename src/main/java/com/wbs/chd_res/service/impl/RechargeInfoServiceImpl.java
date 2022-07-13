package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.RechargeInfoMapper;
import com.wbs.chd_res.pojo.RechargeInfo;
import com.wbs.chd_res.service.RechargeInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbs
 * @create 2022-05-02 18:41
 */
@Service("rechargeInfoServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class RechargeInfoServiceImpl
        extends ServiceImpl<RechargeInfoMapper, RechargeInfo>
        implements RechargeInfoService {
}
