package com.jr.config;


import com.jr.job.PrintLogJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  Quartz相关配置
 */
@Configuration
public class PrintLogQuartzConfig {


    /**************printLogJob begin******************/
    @Bean
    public JobDetail printLogJobConfig(){
        return JobBuilder.newJob(PrintLogJob.class)
                .withIdentity("PrintLogJob")
                .storeDurably()
                .build();
    }
    @Bean
    public Trigger printLogJobTrigger(){
        return TriggerBuilder.newTrigger().forJob(printLogJobConfig())
                .withIdentity("PrintLogJob")
                .withSchedule(CronScheduleBuilder.cronSchedule("1/1 * * * * ?"))
                .build();
    }
    /**************printLogJob end******************/

}
