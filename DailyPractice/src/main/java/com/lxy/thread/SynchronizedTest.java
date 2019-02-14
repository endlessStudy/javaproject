package com.lxy.thread;

/**
 * <p>
 *
 * </p>
 * @author liuyl
 * @date 2018-11-30
 */
class ThreadDemo extends Thread{
    String name;
    ThreadDemo(String name){
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getState());
        synchronized (this) {
            try {
                System.out.println(Thread.currentThread().getState());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
/**
 * @author admin
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        ThreadDemo a = new ThreadDemo("A");
        ThreadDemo b = new ThreadDemo("B");
        synchronized (a) {
            a.start();
        }
        // b.start();
    }
}
