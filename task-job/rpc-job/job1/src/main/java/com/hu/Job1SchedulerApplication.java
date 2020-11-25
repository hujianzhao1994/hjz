package com.hu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Simple to Introduction
 * className: LogbackApplication
 *
 * @author EricYang
 * @version 2018/11/10 11:14
 */
@SpringBootApplication
@Slf4j
public class Job1SchedulerApplication {
    public static void main(String[] args) {
        SpringApplication.run(Job1SchedulerApplication.class, args);
        log.info("Job1SchedulerApplication Start done.");
    }
}
