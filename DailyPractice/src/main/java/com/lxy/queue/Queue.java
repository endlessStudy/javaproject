package com.lxy.queue;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2019-01-29
 */
public class Queue {
	public static void main(String[] args) {
		LinkedBlockingQueue queue = new LinkedBlockingQueue();
		ProducerThread producerThread = new ProducerThread(queue);
		ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
		//Common Thread Pool
		ExecutorService pool = new ThreadPoolExecutor(
				5,
				200,
				0L,
				TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<>(1024),
				namedThreadFactory,
				new ThreadPoolExecutor.AbortPolicy());
		pool.submit(producerThread);
		pool.execute(() -> {

		});
		pool.shutdown();//gracefully shutdown
	}
}

class ProducerThread implements Callable {
	LinkedBlockingQueue queue;

	ProducerThread(LinkedBlockingQueue queue) {
		this.queue = queue;
	}

	@Override
	public Object call() throws Exception {
		return getData();
	}

	public String getData() {
		Object poll = queue.poll();
		if (poll == null) {
			return "暂无数据";
		}
		return poll + "1111";
	}


}