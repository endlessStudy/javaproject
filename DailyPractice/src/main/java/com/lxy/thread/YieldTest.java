package com.lxy.thread;

/**
 * <p>
 *
 * </p>
 * @author liuyl
 * @date 2018-11-30
 */
class ThreadD extends Thread {
	public ThreadD(String name) {
		super(name);
	}

	@Override
	public synchronized void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
			// i整除4时，调用yield
			if (i % 4 == 0) {
				Thread.yield();
			}
		}
	}
}

public class YieldTest {
	public static void main(String[] args) {
		ThreadD threadD1 = new ThreadD("A");
		ThreadD threadD2 = new ThreadD("B");
		threadD1.start();
		threadD2.start();
	}
}
