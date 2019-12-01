package com.my.springbootrabbitmq.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloSenderTest {

    @Autowired
    private HelloSender helloSender;
    @Autowired
    private HelloSenderTwo helloSenderTwo;

    @Test
    public void oneToOne(){
        helloSender.send();
    }

    @Test
    public void oneToMany(){
        for(int i=0;i<50;i++){
            helloSender.senTwo(String.valueOf(i));
        }
    }

    @Test
    public void manyToMany(){
        for(int i=0;i<50;i++){
            helloSender.senTwo(String.valueOf(i));
            helloSenderTwo.senTwo(String.valueOf(i));
        }
    }
}