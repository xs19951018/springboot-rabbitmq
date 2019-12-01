package com.my.springbootrabbitmq.rabbitmq.fanout;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 广播模式/订阅模式
 */
@Configuration
public class FanoutRabbitConfig {

    final static String queueNameA = "fanout.A";
    final static String queueNameB = "fanout.B";
    final static String queueNameC = "fanout.C";

    @Bean
    public Queue queueMessageA(){
        return new Queue(FanoutRabbitConfig.queueNameA);
    }

    @Bean
    public Queue queueMessageB(){
        return new Queue(FanoutRabbitConfig.queueNameB);
    }

    @Bean
    public Queue queueMessageC(){
        return new Queue(FanoutRabbitConfig.queueNameC);
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExangeA(Queue queueMessageA, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueMessageA).to(fanoutExchange);
    }

    @Bean
    Binding bindingExangeB(Queue queueMessageB, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueMessageB).to(fanoutExchange);
    }

    @Bean
    Binding bindingExangeC(Queue queueMessageC, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueMessageC).to(fanoutExchange);
    }
}
