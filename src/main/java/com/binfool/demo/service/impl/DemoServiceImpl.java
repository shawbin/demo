package com.binfool.demo.service.impl;

import com.binfool.demo.service.DemoService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author s915781694@163.com
 * @description
 * @date 2019/6/5 18:26
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Override
    public String testRabbitmq() {
        String context = "hello rabbit " + new Date();
        this.rabbitTemplate.convertAndSend("queueName", context);
        return "SUCCESS";
    }
}
