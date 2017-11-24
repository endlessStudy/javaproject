package com.liuyl.service;

import javax.jms.Destination;

/**
 * Created by liuyl on 2017/11/22.
 */
public interface ProducerService {
    void sendMessage(Destination destination, String msg);
    void sendMessage(String msg);
}
