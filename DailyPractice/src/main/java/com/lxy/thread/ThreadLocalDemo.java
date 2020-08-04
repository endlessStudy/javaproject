package com.lxy.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 * @author liuyl
 * @date 2018-11-29
 */
public class ThreadLocalDemo {
	public static void main(String[] args) {
		ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
				3,
				5,
				2000,
				TimeUnit.MILLISECONDS,
				new LinkedBlockingDeque<Runnable>(2),
				namedThreadFactory,
				new ThreadPoolExecutor.AbortPolicy());
		for (int i = 0; i < 10; i++) {
			try {
				poolExecutor.execute(new MyThread());
			} catch (Exception e) {
				poolExecutor.shutdown();
			}
		}
		poolExecutor.shutdown();
	}
}

class MyThread implements Runnable {
	private String name;
       /* MyThread(String name){
            this.name = name;
        }*/

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread() + " is running");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
