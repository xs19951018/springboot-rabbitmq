package com.my.springbootrabbitmq.rabbitmq.fanout;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FanoutSenderTest {

    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void send(){
        fanoutSender.send();
    }
}