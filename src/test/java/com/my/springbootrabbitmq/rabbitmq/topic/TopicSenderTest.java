package com.my.springbootrabbitmq.rabbitmq.topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicSenderTest {

    @Autowired
    private TopicSender topicSender;

    @Test
    public void send(){
        topicSender.send();
    }

    @Test
    public void sendTwo(){
        topicSender.sendTwo();
    }
}