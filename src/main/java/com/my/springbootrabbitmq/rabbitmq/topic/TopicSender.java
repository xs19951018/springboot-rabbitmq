package com.my.springbootrabbitmq.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String message = "hello:::1";
        System.out.println("send:"+message);
        rabbitTemplate.convertAndSend("exchange", "topic.message", message);
    }

    public void sendTwo(){
        String message = "hello:::2";
        System.out.println("send:"+message);
        rabbitTemplate.convertAndSend("exchange", "topic.messages", message);
    }
}
