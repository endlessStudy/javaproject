package com.lxy.mq.rabbitMq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liuyl on 2018/1/29.
 */
public class Send {
	private final static String QUEUE_NAME = "hello";

	public static void main(String[] args) throws Exception {
		Logger logger = LoggerFactory.getLogger(Send.class);
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("127.0.0.1");
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Hello RubbitMQ !";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
		logger.info(" [x] Sent '" + message + "'");
		channel.close();
		connection.close();
	}

}
