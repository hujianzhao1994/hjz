package com.zhongxiang.back;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 *  确认回调
 */
@Component
public class ConfirmBackConfig implements RabbitTemplate.ConfirmCallback {



    @Autowired
    private RabbitTemplate rabbitTemplate;


    @PostConstruct
    public void init(){
        rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String cause) {

        System.out.println("消息唯一标识："+correlationData);

        System.out.println("确认结果："+b);

        System.out.println("失败原因："+cause);
        System.out.println(correlationData+"---------"+b+"-----------"+cause);
    }
}
