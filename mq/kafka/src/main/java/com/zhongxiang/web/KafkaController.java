package com.gooker.prac.kafka.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.MessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @Description TODO kafka测试案例
 * @Author hjz
 * @Create 2020/9/2 16:48
 **/
@RequestMapping
@RestController
public class KafkaController {


    @Value("${kafka.topic}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    /**
     * @Description:
     *         kafka 生产者
     * @Author hjz
     * @Date 2020/9/8
     **/
    @GetMapping("/send")
    public Object testKafka(){
        String msg = new Random().nextInt(9999)+1000 + " <-> "+ LocalDateTime.now();
        System.out.println("send msg = "+msg);
//        kafkaTemplate.send(topicName, msg);
        kafkaTemplate.send(topicName, msg).addCallback(success -> {
            // 消息发送到的topic
            String topic = success.getRecordMetadata().topic();
            // 消息发送到的分区
            int partition = success.getRecordMetadata().partition();
            // 消息在分区内的offset
            long offset = success.getRecordMetadata().offset();
            System.out.println("发送消息成功:" + topic + "-" + partition + "-" + offset);
        }, failure -> {
            System.out.println("发送消息失败:" + failure.getMessage());

        });
        return  msg;

    }

    /**
     * @Description:
     *         kafka 消费者
     * @Author hjz
     * @Date 2020/9/8
     **/
    @KafkaListener(topics = "${kafka.topic}")
    public void receive(String msg){
        System.out.println("receive  msg = "+msg);
    }

    @GetMapping("/queryTopics")
    public void queryTopics(){
        String defaultTopic = kafkaTemplate.getDefaultTopic();
        MessageConverter messageConverter = kafkaTemplate.getMessageConverter();
        ProducerFactory<String, String> producerFactory = kafkaTemplate.getProducerFactory();
        String transactionIdPrefix = kafkaTemplate.getTransactionIdPrefix();
        System.out.println("defaultTopic="+defaultTopic);
        System.out.println("messageConverter="+messageConverter);
        System.out.println("producerFactory="+producerFactory);
        System.out.println("transactionIdPrefix="+transactionIdPrefix);
    }
}
