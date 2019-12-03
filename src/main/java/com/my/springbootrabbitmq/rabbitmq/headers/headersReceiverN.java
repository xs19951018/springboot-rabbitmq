package com.my.springbootrabbitmq.rabbitmq.headers;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = HeadersRabbitConfig.queueNameB)
public class headersReceiverN {

    @RabbitHandler
    public void process(String message){
        System.out.println("receiverN:*****"+message);
    }
}
