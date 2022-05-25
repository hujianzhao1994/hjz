package com.jr.job;


import com.jr.entity.User;
import com.jr.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class PrintLogJob extends QuartzJobBean {

    @Autowired
    IUserService iUserService;


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        User user = new User();
        user.setName("user1");
        user.setCreated(LocalDateTime.now());
        iUserService.save(user);
        log.info("COMPUTER NAME:【{}】,logTime:【{}】",System.getenv().get("COMPUTERNAME"), LocalDateTime.now());

    }
}
