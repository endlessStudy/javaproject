package com.lxy.order;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2019-01-29
 */
public class Constant {
    public static  LinkedBlockingQueue<Object> objects = new LinkedBlockingQueue<>(3);
    public static final String str = "111";

    public static void add() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String next = scanner.next();
           objects.put(next);
            System.out.println("队列的数量为:"+objects.size());
        }
    }
    public static void get() throws InterruptedException {
        while (true) {
            System.out.println(objects.take());
            System.out.println("队列的数量为:"+objects.size());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        objects.offer("111");
        System.out.println(objects.take());
    }
}
