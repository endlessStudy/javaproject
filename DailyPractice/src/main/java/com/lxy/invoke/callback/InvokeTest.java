package com.lxy.invoke.callback;

import java.lang.reflect.Method;

/**
 * @Author liuyl
 * @date 2018-11-13-18:35
 * @description
 */
public class InvokeTest {
    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("com.lxy.invoke.callback.Atest");
        Object o = clz.newInstance();
        Method m = clz.getMethod("foo", String.class);
        for (int i = 0; i < 16; i++) {
            m.invoke(o, Integer.toString(i));
        }

    }
}


