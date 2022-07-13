package com.wbs.chd_res;

import com.wbs.chd_res.quartz.RecommendationJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChdResApplication implements Runnable {

    public void go() throws Exception {
        // 首先，必需要取得一个Scheduler的引用
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
//        String time="0 51 11 ? * *";
        // jobs可以在scheduled的sched.start()方法前被调用

        // job 1将每隔20秒执行一次
//        JobDetail job = new JobDetail("job1", "group1", myJob.class);
//        CronTrigger trigger = new CronTrigger("trigger1", "group1");
//        trigger.setCronExpression(time);
//        Date ft = sched.scheduleJob(job, trigger);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
//        System.out.println(
//                job.getKey() + " 已被安排执行于: " + sdf.format(ft) + "，并且以如下重复规则重复执行: " + trigger.getCronExpression());
        JobDetail jobDetail= JobBuilder.newJob(RecommendationJob.class) //加载任务类，与HelloJob完成绑定，要求HelloJob实现Job接口
                .withIdentity("job1","group1") //参数1：任务的名称（唯一实例）；参数2：任务组的名称
                .build();
        Trigger trigger= TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1") //参数1：触发器的名称（唯一实例）；参数2：触发器组的名称
                .startNow() //马上启动触发器
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(60)) //每60秒执行一次
                .build();
        //让调度器关联任务和触发器，保证按照触发器定义的条件执行任务
        scheduler.scheduleJob(jobDetail,trigger);

        // 开始执行，start()方法被调用后，计时器就开始工作，计时调度中允许放入N个Job
        scheduler.start();
    }

    @Override
    public void run() {
        try {
            go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        SpringApplication.run(ChdResApplication.class, args);
//        ChdResApplication Thread1=new ChdResApplication();
//        Thread mThread1=new Thread(Thread1,"线程1");
//        mThread1.start();

    }
}
