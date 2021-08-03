package com.fantasy.spring.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class UpdateCronController {

    @Autowired
    private ScheduledForDynamicCron scheduledForDynamicCron;


    @PostMapping("updateCron")
    public void collectCpuAndMemory(String cron) {
        scheduledForDynamicCron.updateCron(cron);
    }


}
