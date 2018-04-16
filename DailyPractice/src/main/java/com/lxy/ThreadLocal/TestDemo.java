package com.lxy.ThreadLocal;


import org.junit.Test;

/**
 * Created by liuyl on 2018/3/26.
 */
public class TestDemo {
    ThreadLocal<String> tl = new ThreadLocal<String>();

    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
    }
}
