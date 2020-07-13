package com.lxy.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * <p>
 *
 * </p>
 * @author liuyl
 * @date 2018-11-29
 */
public class ThreadLocalQuestion {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static int getValue() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }

    public static void increment() {
        threadLocal.set(threadLocal.get() + 1);
    }

    public static void main(String[] args) {
        ThreadFactory build = new ThreadFactoryBuilder().setNameFormat("Pool-Thread-%d").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 10, 2000, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), build, new ThreadPoolExecutor.AbortPolicy()
        );
        for (int i = 0; i < 5; i++) {
            //submit 有返回值,可以通过future.get()获取异常,不会自动抛出异常
            Future future = executor.submit(() -> {
                    System.out.println(1 / 0);
                    int before = getValue();
                    increment();
                    int after = getValue();
                    System.out.println(Thread.currentThread().getId() + "before: " + before + ", after: " + after);
            });
           /* //没有返回值,抛出异常不需要手动捕获
            executor.execute(() -> {
                    System.out.println(1 / 0);
                    int before = getValue();
                    increment();
                    int after = getValue();
                    System.out.println(Thread.currentThread().getId() + "before: " + before + ", after: " + after);
            });*/
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}
