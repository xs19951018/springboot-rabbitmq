package com.my.springbootrabbitmq.rabbitmq.direct;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class DirectConfig {

    @Bean
    public Queue directQueue(){
        return new Queue("direct.core");
    }
}
