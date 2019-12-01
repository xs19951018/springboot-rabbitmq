package com.my.springbootrabbitmq.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = FanoutRabbitConfig.queueNameB)
public class FanoutReceiverB {

    @RabbitHandler
    public void process(String message){
        System.out.println("receiverB:*****"+message);
    }
}
