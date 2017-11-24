package com.liuyl.service.impl;

import com.liuyl.common.Global;
import com.liuyl.service.ConsumerService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by liuyl on 2017/11/22.
 */
@Service
public class ConsumerServiceImpl extends Global implements ConsumerService{
    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;
    @Override
    public TextMessage receive(Destination destination){
        logger.info("开始接收数据.....");
        TextMessage textMessage =  (TextMessage) jmsTemplate.receive("spittle.alert.queue");
        try{
            System.out.println("从队列" + destination.toString() + "收到了消息：t"
                    + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return textMessage;
    }
}
