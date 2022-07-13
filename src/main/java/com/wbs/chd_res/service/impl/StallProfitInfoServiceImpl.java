package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.StallProfitInfoMapper;
import com.wbs.chd_res.pojo.StallProfitInfo;
import com.wbs.chd_res.service.StallProfitInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbs
 * @create 2022-05-02 18:57
 */
@Service("stallProfitInfoServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class StallProfitInfoServiceImpl
        extends ServiceImpl<StallProfitInfoMapper, StallProfitInfo>
        implements StallProfitInfoService {
}
