package com.liuyl.service.impl;

import com.liuyl.common.Global;
import com.liuyl.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by liuyl on 2017/11/22.
 */
@Service
public class ProducerServiceImpl extends Global implements ProducerService{
    @Autowired
    private JmsTemplate jmsTemplate;
    @Override
    public void sendMessage(Destination destination, String msg){
        logger.info(Thread.currentThread().getName()+"通过sendMessage(Destination destination,String msg) 向队列"+destination.toString()+"发送消息---------------------->"+msg);
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }
    @Override
    public void sendMessage(String msg){
        String destination = jmsTemplate.getDefaultDestinationName();
        logger.info(Thread.currentThread().getName()+"通过sendMessage(String msg) 向队列"+destination+"发送消息---------------------->"+msg);
        jmsTemplate.send("spittle.alert.queue",new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }
}
