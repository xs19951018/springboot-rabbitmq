package com.my.springbootrabbitmq.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSenderTwo {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String message = "hello"+new Date();
        System.out.println("send:"+message);
        rabbitTemplate.convertAndSend("hello", message);
    }

    public void senTwo(String i){
        rabbitTemplate.convertAndSend("hello", i);
    }
}
