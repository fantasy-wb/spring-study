package com.fantasy.spring.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 使用@Scheduled创建任务时无法在同一时间执行多个任务
 * 解决： 配置TaskScheduler
 */
@Component
public class MyScheduled {


    /**
     * @ EnableScheduling 注解的 @Import({SchedulingConfiguration.class})
     * 如果没有指定TaskScheduler 则会创建一个单线程的默认调度器。
     * 即taskScheduler对象为空时默认创建的是newSingleThreadScheduledExecutor()
     * @return
     */
//    @Bean
//    public TaskScheduler taskScheduler() {
//        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//        taskScheduler.setPoolSize(50);
//        return taskScheduler;
//    }

//    @Scheduled(cron = "0/5 * * * * ?")
    public void execute1(){
        String curName = Thread.currentThread().getName() ;
        System.out.println("当前时间:"+LocalDateTime.now()+"  任务execute1对应的线程名: "+curName);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    @Scheduled(cron = "0/5 * * * * ?")
    public void execute2(){

        String curName = Thread.currentThread().getName() ;
        System.out.println("当前时间:"+LocalDateTime.now()+"  任务execute2对应的线程名: "+curName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}