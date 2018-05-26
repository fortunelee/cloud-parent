package com.cloud.service.feign.kafka.producer;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MsgProducer {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;
    Logger logger = Logger.getLogger(MsgProducer.class);

    public void send(List<String> msgs) {
        for (String msg : msgs) {
            kafkaTemplate.send("test", msg);
        }
        kafkaTemplate.send("my-replicated-topic2", "MSG");

    }
}
