package com.zhongxiang.web;

import com.rabbitmq.client.Channel;
import com.zhongxiang.config.GeneralRabbitConfig;
import com.zhongxiang.config.PluginDelayConfig;
import com.zhongxiang.config.TTLDelayConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * 测试几种rabbitMQ的发消息以及接收消息
 * @Author hjz
 * @Create 2020/10/21 14:45
 **/
@RestController
public class RabbitMqController {


    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    AmqpTemplate amqpTemplate;

    /*****************************************************************普通队列 Begin *********************************************/
    @GetMapping("/general")
    public Object sendGeneralMsg(){
        Map<String,Object> map = new HashMap<>();
        map.put("id", "2334");
        map.put("name", "呼呼");
        amqpTemplate.convertAndSend(
                GeneralRabbitConfig.GENERAL_EXCHANGE,
                GeneralRabbitConfig.GENERAL_QUEUE_KEY,
                map,
                message -> {
                    message.getMessageProperties().setContentEncoding("UTF-8");
                    // 设置消息持久化
                    message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    log.info("普通队列 发送消息成功!message：" + message);
                    return message;
                }
        );

        log.info("普通队列 发送消息成功!当前时间：" + LocalDateTime.now());
        return map;
    }

    @RabbitListener(queues = GeneralRabbitConfig.GENERAL_QUEUE)
    @Retryable(value = Exception.class, maxAttempts = 3)
    public void receiveGeneralMsg(Map<String, Object> map, Message message, Channel channel){
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            String receivedMsg = new String(message.getBody(), "UTF-8");
            log.info("普通队列  rabbitMQ 接受成功, map=" + map + " 当前时间：" + LocalDateTime.now());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
        }
        try {
            channel.basicAck(deliveryTag,true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /*****************************************************************普通队列 END *********************************************/


    /*****************************************************************TTL BEGIN *********************************************/
    /**
     * @Description: 
     *         延时队列：控制消息在一段时间后变成死信，又可以控制变成死信的消息被路由到某一个指定的交换机
     * @Author hjz
     * @Date 2020/10/21
     **/
    @GetMapping("/ttlPublish")
    public Object test() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "2334");
        map.put("name", "ttlPublish");
        amqpTemplate.convertAndSend(
                TTLDelayConfig.DELAY_EXCHANGE,
                TTLDelayConfig.DELAY_QUEUE_KEY,
                map,
                message -> {
                    message.getMessageProperties().setContentEncoding("UTF-8");
                    // 设置消息持久化
                    message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    // 设置延迟时
                    message.getMessageProperties().setExpiration(15 * 1000+"");
                    return message;
                });
        log.info("TTL模式rabbitMQ 发送 成功!当前时间：" + LocalDateTime.now());
        return "ttlPublish OK";
    }
    @RabbitHandler
    @RabbitListener(queues = TTLDelayConfig.BAK_DELAY_QUEUE)
    @Retryable(value = Exception.class, maxAttempts = 3)
    public void getMessage(Map<String, Object> map, Message message,Channel channel) {
        try {
            log.info("TTL模式rabbitMQ延时  rabbitMQ 接受成功, map=" + map + " 当前时间：" + LocalDateTime.now());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        } catch (Exception e) {
            log.info("TTL模式rabbitMQ延时  receiver fail ");
        }

    }
    /*****************************************************************TTL END *********************************************/



    /*****************************************************************插件方法 BEGIN *********************************************/
    @GetMapping("/pluginPublish")
    public Object pluginPublish() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "2334");
        map.put("name", "呼呼");
        amqpTemplate.convertAndSend(
                PluginDelayConfig.PLUGIN_DELAY_EXCHANGE,
                PluginDelayConfig.PLUGIN_DELAY_QUEUE_KEY,
                map,
                message -> {
                    message.getMessageProperties().setContentEncoding("UTF-8");
                    //设置延迟时
                    message.getMessageProperties().setDelay(5 * 1000);
                    return message;
                });
        log.info("插件模式rabbitMQ 发送 成功!当前时间：" + LocalDateTime.now());
        return "pluginPublish OK";
    }


    @RabbitHandler
    @RabbitListener(queues = PluginDelayConfig.PLUGIN_DELAY_QUEUE)
    @Retryable(value = Exception.class, maxAttempts = 3)
    public void pluginGetMessage(Map<String, Object> map,Message message, Channel channel) {
        try {
            log.info("插件模式rabbitMQ延时  rabbitMQ 接受成功, map=" + map + " 当前时间：" + LocalDateTime.now());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        } catch (Exception e) {
            log.info("插件模式rabbitMQ延时  receiver fail ");
        }
    }

/*****************************************************************插件方法 END *********************************************/
}
