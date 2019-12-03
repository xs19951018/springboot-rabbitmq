package com.my.springbootrabbitmq.rabbitmq.headers;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class headersSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendA(Map<String, Object> header, String message){
        System.out.println("sendA:发送消息"+message);
        rabbitTemplate.convertAndSend("headersExchangeM", "", getMessage(header, message));
    }

    public void sendB(Map<String, Object> header, String message){
        System.out.println("sendB:发送消息"+message);
        rabbitTemplate.convertAndSend("headersExchangeN", "", getMessage(header, message));
    }


    private Message getMessage(Map<String, Object> head, Object msg){
        MessageProperties messageProperties = new MessageProperties();
        for (Map.Entry<String, Object> entry : head.entrySet()) {
            messageProperties.setHeader(entry.getKey(), entry.getValue());
        }
        MessageConverter messageConverter = new SimpleMessageConverter();
        return messageConverter.toMessage(msg, messageProperties);
    }
}
