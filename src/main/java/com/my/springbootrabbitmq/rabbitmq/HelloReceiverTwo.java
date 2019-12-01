package com.my.springbootrabbitmq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiverTwo {

    @RabbitHandler
    public void process(String message){
        System.out.println("receiver2:****"+message);
    }
}
