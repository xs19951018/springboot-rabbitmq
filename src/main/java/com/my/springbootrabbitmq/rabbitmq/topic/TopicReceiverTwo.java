package com.my.springbootrabbitmq.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = TopicRabbitConfig.queueNameTwo)
public class TopicReceiverTwo {

    @RabbitHandler
    public void process(String message){
        System.out.println("receiver2:****"+message);
    }
}
