package com.zhongxiang.base;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @Description TODO
 * java原生生产者
 * @Author hjz
 * @Create 2020/10/22 16:39
 **/
public class OneProducer {

    private KafkaProducer<Integer, String> producer;

    public OneProducer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "192.169.18.187:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSeralizer");
        properties.put("bootstrap.servers", "org.apache.kafka.common.serialization.StringSerializer");
        this.producer = new KafkaProducer<Integer, String>(properties);
    }


    public void sendMsg() {
        ProducerRecord<Integer, String> record = new ProducerRecord<>("city", 0, 1, "shanghai");
        this.producer.send(record);
    }

}
