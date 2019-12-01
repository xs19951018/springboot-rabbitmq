package com.my.springbootrabbitmq.rabbitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String message = "hello:::1";
        System.out.println("send:"+message);
        rabbitTemplate.convertAndSend("fanoutExchange", "", message);
    }

}
