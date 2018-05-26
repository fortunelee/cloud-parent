package com.cloud.service.db.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * /**消息消费者
 * @author Zj.Qu
 *
 */
@Component
public class MsgConsumer {

    Logger logger = Logger.getLogger(MsgConsumer.class);
    @KafkaListener(topics = {"my-replicated-topic"},group = "myGroup")
    public String processMsg(ConsumerRecord data){
        System.out.println("topic: "+data.topic());
        System.out.println("key: "+data.key());
        System.out.println("value: "+data.value());
        return data.value().toString();
    }

    @KafkaListener(topics = {"my-replicated-topic2"},group = "myGroup")
    public String processMsg2(ConsumerRecord data){
        System.out.println("topic: "+data.topic());
        System.out.println("key: "+data.key());
        System.out.println("value: "+data.value());
        return data.value().toString();
    }

}
