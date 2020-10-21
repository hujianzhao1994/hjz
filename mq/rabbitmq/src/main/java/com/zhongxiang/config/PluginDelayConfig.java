package com.zhongxiang.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 *      插件式 延时队列
 */
@Configuration
public class PluginDelayConfig {


    public static final String PLUGIN_DELAY_EXCHANGE = "plugin_delay_exchange";

    public static final String PLUGIN_DELAY_QUEUE = "plugin_delay_queue";

    public static final String PLUGIN_DELAY_QUEUE_KEY = "plugin_delay_queue_key";


    /**
     *      普通队列
     * @return
     */
    @Bean(name = PLUGIN_DELAY_QUEUE)
    public Queue plugin_delay_queue(){
        Queue queue = new Queue(PLUGIN_DELAY_QUEUE,true,false,false);
        return queue;
    }


    /**
     *      定义延时交换机，类型为direct
     * @return
     */
    @Bean(name = PLUGIN_DELAY_EXCHANGE)
    public Exchange plguin_delay_exchange(){
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        CustomExchange exchange = new CustomExchange(PLUGIN_DELAY_EXCHANGE,"x-delayed-message",true,false,args);
        return exchange;
    }

    /**
     *      将对列绑定到 延时交换机
     *
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding plguin_bindingExchange(@Qualifier(PLUGIN_DELAY_QUEUE) Queue queue, @Qualifier(PLUGIN_DELAY_EXCHANGE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(PLUGIN_DELAY_QUEUE_KEY).noargs();
    }
}
