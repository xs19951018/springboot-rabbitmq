package com.my.springbootrabbitmq.rabbitmq.fanout;

import com.my.springbootrabbitmq.rabbitmq.topic.TopicRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = FanoutRabbitConfig.queueNameA)
public class FanoutReceiverA {

    @RabbitHandler
    public void process(String message){
        System.out.println("receiverA:*****"+message);
    }
}
