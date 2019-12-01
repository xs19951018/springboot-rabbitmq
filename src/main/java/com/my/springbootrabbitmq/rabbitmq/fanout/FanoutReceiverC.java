package com.my.springbootrabbitmq.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = FanoutRabbitConfig.queueNameC)
public class FanoutReceiverC {

    @RabbitHandler
    public void process(String message){
        System.out.println("receiverC:*****"+message);
    }
}
