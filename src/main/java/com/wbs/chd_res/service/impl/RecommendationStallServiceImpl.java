package com.wbs.chd_res.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.chd_res.mapper.RecommendationStallMapper;
import com.wbs.chd_res.pojo.ReStallInfo;
import com.wbs.chd_res.pojo.RecommendationStall;
import com.wbs.chd_res.pojo.StallInfo;
import com.wbs.chd_res.service.RecommendationStallService;
import com.wbs.chd_res.service.StallInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @author wbs
 * @create 2022-05-04 8:51
 */
@Service("recommendationStallServiceImpl")    //使其被spring初始化
@Transactional  //加入事务控制
public class RecommendationStallServiceImpl
        extends ServiceImpl<RecommendationStallMapper,RecommendationStall>
        implements RecommendationStallService {

    @Autowired
    private StallInfoService stallInfoService;
    @Autowired
    private  RecommendationStallMapper recommendationStallMapper;

//    计算推荐信息
    @Override
    public void computedRecommendation() {
//        先移除不是管理员设置的推荐
        QueryWrapper<RecommendationStall> queryWrapper=new QueryWrapper<>();
        QueryWrapper<RecommendationStall> is_admin = queryWrapper.eq("is_admin", 0);
        int delete = baseMapper.delete(queryWrapper);
//        List<RecommendationStall> list = baseMapper.selectList(queryWrapper);

//        从stall_info中读取三个今日推荐者
        QueryWrapper<StallInfo> stallInfoQueryWrapper=new QueryWrapper<>();
        stallInfoQueryWrapper.gt("stall_id", 0);
        List<StallInfo> newRecommendations = stallInfoService.list(stallInfoQueryWrapper);
        newRecommendations.sort(Comparator.comparing(StallInfo::getStallAccount).reversed());
//        使用迭代器将其插入推荐表单
        Iterator<StallInfo> iterator = newRecommendations.iterator();
        int i=0;
        while (iterator.hasNext()) {
            StallInfo stall = iterator.next();
            i++;
            if(i<=3){
//                插入前先检查该记录是否已经在数据库中
                QueryWrapper<RecommendationStall> queryWrapperH=new QueryWrapper<>();
                queryWrapperH.eq("stall_id", stall.getStallId());
                if(baseMapper.selectCount(queryWrapperH)==0){
                    recommendationStallMapper.myInsert(stall.getStallId(), 0);

                }
            }
        }
    }

//    返回所有推荐信息
    @Override
    public List<RecommendationStall> getAll() {
        QueryWrapper<RecommendationStall> queryWrapper=new QueryWrapper<>();
        queryWrapper.gt("stall_id", 0);
//        baseMapper.delete(queryWrapper);

        return baseMapper.selectList(queryWrapper);
    }

}
