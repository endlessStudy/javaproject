package com.lxy.thread;

/**
 * <p>
 *
 * </p>
 * @author liuyl
 * @date 2018-12-04
 */
// Demo2.java的源码
class MyThread3 extends Thread {

	public MyThread3(String name) {
		super(name);
	}

	@Override
	public void run() {
		try {
			int i = 0;
			while (!isInterrupted()) {
				// 休眠100ms
				Thread.sleep(100);
				i++;
				System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptedException.");
		}
	}
}

public class Demo2 {

	public static void main(String[] args) {
		try {
			Thread t1 = new MyThread3("t1");  // 新建“线程t1”
			System.out.println(t1.getName() + " (" + t1.getState() + ") is new.");

			t1.start();                      // 启动“线程t1”
			System.out.println(t1.getName() + " (" + t1.getState() + ") is started.");

			// 主线程休眠300ms，然后主线程给t1发“中断”指令。
			Thread.sleep(300);
			t1.interrupt();
			System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted.");

			// 主线程休眠300ms，然后查看t1的状态。
			Thread.sleep(300);
			System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted now.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
