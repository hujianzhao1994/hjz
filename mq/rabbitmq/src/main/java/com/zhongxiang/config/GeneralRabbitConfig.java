package com.zhongxiang.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * 普通队列配置类
 * @Author hjz
 * @Create 2020/10/21 14:20
 **/
@Configuration
public class GeneralRabbitConfig {

    /**
     *  声明 交换机，队列，key
     */
    public static final String GENERAL_EXCHANGE = "general_exchange";

    public static final String GENERAL_QUEUE = "general_queue";

    public static final String GENERAL_QUEUE_KEY = "general_queue_key";


    /**
     *  定义普通队列
     * @return
     */
    @Bean(name=GENERAL_QUEUE)
    public Queue queue(){
        return QueueBuilder.durable(GENERAL_QUEUE).build();
    }


    /**
     *      定义普通交换机
     * @return
     */
    @Bean(name=GENERAL_EXCHANGE)
    public Exchange exchange(){
        return ExchangeBuilder.topicExchange(GENERAL_EXCHANGE).durable(true).build();
    }


    /**
     *      将队列以 key  绑定到交换机上
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding binding_exchange(@Qualifier(GENERAL_QUEUE) Queue queue,
                                    @Qualifier(GENERAL_EXCHANGE) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(GENERAL_QUEUE_KEY).noargs();
    }



}
