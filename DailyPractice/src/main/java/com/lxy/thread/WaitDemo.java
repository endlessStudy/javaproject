package com.lxy.thread;

import net.sf.ehcache.concurrent.Sync;

/**
 * <p>
 *
 * </p>
 * @author liuyl
 * @date 2018-11-30
 */
class ThreadA extends Thread {

    public ThreadA(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println("进入run()方法,等待释放锁");
        synchronized (this) { // 3
            System.out.println("获取锁,执行方法!");
            try {
                // wait();
                  Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " call notify()");
            // 唤醒当前的wait线程
            // notify();//如果
        }
    }
}

public class WaitDemo {
    public static void main(String[] args) {

        ThreadA t1 = new ThreadA("t1");
        //此时t1被占用,无法执行run()中的代码块
        synchronized (t1) { // 1
            try {
                // 启动“线程t1”
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();  // 2
                // 主线程等待t1通过notify()唤醒。
                System.out.println(Thread.currentThread().getName() + " wait()");
                // t1.wait(3000);
                t1.wait();// 4 线程等待,释放锁资源,将会执行run()中的同步代码块.如果注释掉将会在continue执行完之后,也就是代码块执行完之后释放t1,然后执行run()中的同步代码块

                System.out.println(t1.getName());
                // Thread.sleep(10000); // 5

                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
