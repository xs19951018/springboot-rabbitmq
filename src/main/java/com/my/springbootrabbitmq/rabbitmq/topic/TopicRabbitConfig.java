package com.my.springbootrabbitmq.rabbitmq.topic;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 主题模式/通配符模式
 */
@Configuration
public class TopicRabbitConfig {

    final static String queueName = "topic.message";
    final static String queueNameTwo = "topic.messages";

    @Bean
    public Queue queueMessage(){
        return new Queue(TopicRabbitConfig.queueName);
    }

    @Bean
    public Queue queueMessages(){
        return new Queue(TopicRabbitConfig.queueNameTwo);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExangeMessage(Queue queueMessage, TopicExchange exchange){
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExangeMessages(Queue queueMessages, TopicExchange exchange){
        // queueMessages 匹配到两个键
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
