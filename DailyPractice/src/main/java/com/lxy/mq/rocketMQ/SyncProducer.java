package com.lxy.mq.rocketMQ;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * <p>
 * |****************************** *_* ******************************|
 * |   __                                                      __    |
 * | _/  |_  ____ _____ _______    ______ _____ _____ ________/  |_  |
 * | \   __\/ __ \\__  \\_  __ \  /  ___//     \\__  \\_  __ \   __\ |
 * |  |  | \  ___/ / __ \|  | \/  \___ \|  Y Y  \/ __ \|  | \/|  |   |
 * |  |__|  \___  >____  /__|    /____  >__|_|  (____  /__|   |__|   |
 * |            \/     \/             \/      \/     \/              |
 * |                                                                 |
 * |****************************** *_* ******************************|
 * </p>
 * @author tear-smart
 * @date 2019-06-19
 */
public class SyncProducer {
	public static void main(String[] args) {
		DefaultMQProducer producer = new DefaultMQProducer("sync_group");
		// producer.setNamesrvAddr("localhost:9876");
		producer.setNamesrvAddr("58.87.122.79:9876");
		producer.setSendMsgTimeout(10000);
		try {
			producer.start();
			Message message = new Message();
			message.setTopic("sync_topic");
			message.setTags("syncA");
			message.setBody("error".getBytes());
			SendResult sendResult = producer.send(message, 10000);
			System.out.println(producer.getProducerGroup());
		} catch (Exception e) {
			System.out.println("错误信息为: " + e.getMessage() + " : " + e.getCause());
		} finally {
			producer.shutdown();
		}


	}
}
