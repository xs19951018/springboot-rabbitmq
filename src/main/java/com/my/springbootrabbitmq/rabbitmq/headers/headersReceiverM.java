package com.my.springbootrabbitmq.rabbitmq.headers;

import com.my.springbootrabbitmq.rabbitmq.fanout.FanoutRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = HeadersRabbitConfig.queueNameA)
public class headersReceiverM {

    @RabbitHandler
    public void process(String message){
        System.out.println("receiverM:*****"+message);
    }
}
