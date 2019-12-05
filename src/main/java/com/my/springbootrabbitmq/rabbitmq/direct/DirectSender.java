package com.my.springbootrabbitmq.rabbitmq.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String message = "你好";
        System.out.println("send:"+message);
        rabbitTemplate.convertAndSend("direct.core", message);
    }

}
