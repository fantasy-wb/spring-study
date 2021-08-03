package com.fantasy.spring.schedule;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class ScheduledForDynamicCron implements SchedulingConfigurer {

    @Autowired
    private TaskCronProperties taskCronProperties;


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        taskRegistrar.addTriggerTask(() -> {

            log.info("开始自动备份>>>>>>>>>>>>>>>>>>>>>>");

        }, (triggerContext) -> {
            // 定时任务触发，可修改定时任务的执行周期
            CronTrigger trigger = new CronTrigger(taskCronProperties.getCron());
            Date nextExecDate = trigger.nextExecutionTime(triggerContext);
            return nextExecDate;
        });
    }

    /**
     * 修改任务 cron
     * @param cron
     */
    public void updateCron(String cron) {
        System.out.println("当前cron=" + taskCronProperties.getCron() + "->将被改变为：" + cron);
        taskCronProperties.setCron(cron);
    }

}