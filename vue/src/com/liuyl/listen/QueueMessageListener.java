package com.liuyl.listen;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by liuyl on 2017/11/22.
 */
public class QueueMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println(getClass().getSimpleName()+"监听到了文本信息"+ textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
