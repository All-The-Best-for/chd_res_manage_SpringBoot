package com.wbs.chd_res.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wbs.chd_res.pojo.ReStallInfo;
import com.wbs.chd_res.pojo.RecommendationStall;
import com.wbs.chd_res.pojo.StallInfo;
import com.wbs.chd_res.service.RecommendationStallService;
import com.wbs.chd_res.service.StallInfoService;
import com.wbs.chd_res.util.Result;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author wbs
 * @create 2022-05-04 8:58
 */
@RestController //前后端异步交互使用这个注解
@RequestMapping("/sms/recommendationStallController")
public class RecommendationStallController {

    @Autowired
    private RecommendationStallService recommendationStallService;
    @Autowired
    private StallInfoService stallInfoService;

    @GetMapping("/getRecommendation")
    public Result getRecommendation(){
        Map<String,Object> map=new LinkedHashMap<>();
//        从商家列表中读出数据并按照销量进行排序
        QueryWrapper<StallInfo> stallInfoQueryWrapper=new QueryWrapper<>();
        stallInfoQueryWrapper.orderByDesc("amount");
        List<StallInfo> list = stallInfoService.list(stallInfoQueryWrapper);
        Iterator<StallInfo> iterator=list.iterator();
        ArrayList<StallInfo> stalls = new ArrayList<>();
        int i=0;
        while (iterator.hasNext()){
            StallInfo reStall=iterator.next();
            if(i<3){
                if(reStall.getIsWork()==1){
                    stalls.add(reStall);
                }
                i++;
            }
        }
        map.put("stalls", stalls);

        return Result.ok(map);
    }

    @GetMapping("/computed")
    public Result computed(){
        recommendationStallService.computedRecommendation();
        return Result.ok();
    }
}
