package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.StallInfoMapper;
import com.wbs.chd_res.pojo.StallInfo;
import com.wbs.chd_res.service.StallInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbs
 * @create 2022-05-02 18:56
 */
@Service("stallInfoServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class StallInfoServiceImpl extends ServiceImpl<StallInfoMapper, StallInfo> implements StallInfoService {

    @Override
    public List<StallInfo> getStalls() {
        List<StallInfo> stallInfoList=baseMapper.selectList(null);
        return stallInfoList;
    }
}
