package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.ResProfitInfoMapper;
import com.wbs.chd_res.pojo.ResProfitInfo;
import com.wbs.chd_res.service.ResProfitInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbs
 * @create 2022-05-02 18:46
 */
@Service("resProfitInfoServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class ResProfitInfoServiceImpl
        extends ServiceImpl<ResProfitInfoMapper, ResProfitInfo>
        implements ResProfitInfoService {
}
