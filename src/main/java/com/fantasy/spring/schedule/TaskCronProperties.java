package com.fantasy.spring.schedule;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "my-task")
public class TaskCronProperties {

    private String name;

    private String cron;

}
