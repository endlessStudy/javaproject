package com.lxy;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liuyl on 2018/1/31.
 */
public class Test {
    static Integer i = 222;
    public static void main(String[] args) {
        change(i);
        System.out.println(i);
    }
    public static void change(int str ) {

        ++str;
    }
}