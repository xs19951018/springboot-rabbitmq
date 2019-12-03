package com.my.springbootrabbitmq.rabbitmq.headers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class headersSenderTest {

    @Autowired
    private headersSender headersSender;

    @Test
    public void test(){
        Map<String,Object> head = new HashMap<>();
        head.put("type", "cash");
        headersSender.sendA(head, "银行授信(部分匹配)");

        Map<String,Object> head2 = new HashMap<>();
        head2.put("type", "cash");
        head2.put("sign", "fast");
        headersSender.sendA(head2, "银行授信(完全匹配)");

        Map<String,Object> head3 = new HashMap<>();
        head3.put("type", "cash");
        headersSender.sendB(head3, "金融公司(部分匹配)");

        Map<String,Object> head4 = new HashMap<>();
        head4.put("type", "cash");
        head4.put("sign", "fast");
        headersSender.sendB(head4, "金融公司(完全匹配)");
    }
}