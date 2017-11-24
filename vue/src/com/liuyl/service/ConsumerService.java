package com.liuyl.service;

import javax.jms.Destination;
import javax.jms.TextMessage;

/**
 * Created by liuyl on 2017/11/22.
 */
public interface ConsumerService {
    TextMessage receive(Destination destination);
}
