package com.my.springbootrabbitmq.rabbitmq.headers;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * headersExchange
 */
@Configuration
public class HeadersRabbitConfig {

    final static String queueNameA = "header.A";
    final static String queueNameB = "header.B";

    @Bean
    public Queue queueMessageM(){
        return new Queue(HeadersRabbitConfig.queueNameA);
    }

    @Bean
    public Queue queueMessageN(){
        return new Queue(HeadersRabbitConfig.queueNameB);
    }

    @Bean
    HeadersExchange headersExchangeM(){
        return new HeadersExchange("headersExchangeM");
    }

    @Bean
    HeadersExchange headersExchangeN(){
        return new HeadersExchange("headersExchangeN");
    }

    @Bean
    Binding bindingExangeM(Queue queueMessageA, HeadersExchange headersExchangeM){
        Map<String, Object> header = new HashMap<>();
        header.put("type", "cash");
        header.put("sign", "fast");
        return BindingBuilder.bind(queueMessageA).to(headersExchangeM).whereAll(header).match();
    }

    @Bean
    Binding bindingExangeN(Queue queueMessageB, HeadersExchange headersExchangeN){
        Map<String, Object> header = new HashMap<>();
        header.put("type", "cash");
        header.put("sign", "fast");
        return BindingBuilder.bind(queueMessageB).to(headersExchangeN).whereAny(header).match();
    }

}
