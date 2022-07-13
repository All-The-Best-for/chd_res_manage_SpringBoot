package com.wbs.chd_res.quartz;

import com.wbs.chd_res.service.RecommendationStallService;
import com.wbs.chd_res.service.impl.RecommendationStallServiceImpl;
import org.junit.Test;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 专门用来定时计算生成每日最新的热门推荐店铺
 *
 * @author wbs
 * @create 2022-05-04 8:32
 */
public class RecommendationJob implements Job {

//    @Autowired
//    private RecommendationStallService recommendationStallService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString=dateFormat.format(date);
        //工作内容
        System.out.println("执行定时任务，时间是："+dateString);
        new RecommendationStallServiceImpl().computedRecommendation();
    }

}
