package com.zhongxiang.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 
 *         TTL延时交换机
 *         队列设置了DLX(x-dead-letter-exchange),并通过 x-dead-letter-routing-key设置消息发送到DLX所用的routing-key（不设置默认使用消息本身的routing-key）
 *         控制消息在一段时间后变成死信，又可以控制变成死信的消息被routing-key路由到某一个指定的交换机
 * @Author hjz
 * @Date 2020/10/21
 **/
@Configuration
public class TTLDelayConfig {

    public static final String DELAY_EXCHANGE = "delay_exchange";

    public static final String DELAY_QUEUE = "delay_queue";
    public static final String DELAY_QUEUE_KEY = "delay_queue_key";


    public static final String BAK_DELAY_QUEUE = "bak_delay_queue";
    public static final String BAK_DELAY_QUEUE_KEY = "bak_delay_queue_key";



    @Bean(name = DELAY_QUEUE)
    public Queue delay_queue(){
        Map<String, Object> map = new HashMap<>();
        map.put("x-dead-letter-exchange",DELAY_EXCHANGE);
        map.put("x-dead-letter-routing-key",BAK_DELAY_QUEUE_KEY);
//        return QueueBuilder.durable(DELAY_QUEUE).withArguments(map).build();
        Queue queue = new Queue(DELAY_QUEUE,true,false,false,map);
        return queue;
    }

    @Bean(name = DELAY_EXCHANGE)
    public Exchange delay_exchange(){
//        return ExchangeBuilder.directExchange(DELAY_EXCHANGE).durable(true).build();
        return new DirectExchange(DELAY_EXCHANGE, true, false);

    }

    @Bean
    public Binding bindingExchange(@Qualifier(DELAY_QUEUE) Queue queue, @Qualifier(DELAY_EXCHANGE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DELAY_QUEUE_KEY).noargs();
    }



    @Bean(name = BAK_DELAY_QUEUE)
    public Queue bak_delay_queue(){
        Queue queue = new Queue(BAK_DELAY_QUEUE,true,false,false,null);
        return queue;
    }

    @Bean
    public Binding bakbindingExchange(@Qualifier(BAK_DELAY_QUEUE) Queue queue, @Qualifier(DELAY_EXCHANGE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(BAK_DELAY_QUEUE_KEY).noargs();

    }
}
