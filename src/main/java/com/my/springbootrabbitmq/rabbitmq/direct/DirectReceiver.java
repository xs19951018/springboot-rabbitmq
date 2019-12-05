package com.my.springbootrabbitmq.rabbitmq.direct;

import com.my.springbootrabbitmq.rabbitmq.fanout.FanoutRabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "direct.core")
public class DirectReceiver {

    @RabbitHandler
    public void process(String message){
        System.out.println("receiver:*****"+message);
    }
}
