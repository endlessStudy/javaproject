package com.lxy.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *
 * </p>
 * @author liuyl
 * @date 2018-12-03
 */
public class LockTest1 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        try {
            lock.wait();
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
