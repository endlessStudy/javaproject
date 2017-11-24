package com.liuyl.controller;

import com.liuyl.common.Global;
import com.liuyl.service.ConsumerService;
import com.liuyl.service.ProducerService;
import com.liuyl.service.impl.ConsumerServiceImpl;
import com.liuyl.service.impl.ProducerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import javax.jms.Destination;
import javax.jms.TextMessage;
import javax.print.DocFlavor;

/**
 * Created by liuyl on 2017/11/22.
 */
@Controller
@RequestMapping("/mq")
public class MessageController extends Global {
    @Resource(name = "demoQueueDestination")
    private Destination destination;
    @Autowired
    private ProducerService producerService;
    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    @ResponseBody
    public void send(String msg) {
        logger.info(Thread.currentThread().getName()+"------------send to jms Start");
        producerService.sendMessage(msg);
        logger.info(Thread.currentThread().getName()+"------------send to jms End");
    }
    @RequestMapping(value = "/receive",method = RequestMethod.GET)
    @ResponseBody
    public Object receive() {
        destination.toString();
        logger.info(Thread.currentThread().getName()+"------------receive from jms Start");
        TextMessage tm = consumerService.receive(destination);
        logger.info(Thread.currentThread().getName()+"------------receive from jms End");
        return tm;
    }
}
