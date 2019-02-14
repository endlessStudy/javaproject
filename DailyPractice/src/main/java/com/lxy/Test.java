package com.lxy;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liuyl on 2018/1/31.
 */

public class Test {
    public static void main(String[] args) {
        System.out.println("46127492@qq.com".matches("^[1-9][0-9]{4,9}@qq\\.com$"));
    }

    @org.junit.Test
    public void fun02() {
        int count1 = 0, count2 = 0;
        for (int i = 0; i <= 200; i++) {
            // 每一个数一个个接受检验是否为素数
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j != 0) {
                    //不能被整除累计一次
                    count1++;
                }
            }
            // 转为int的类型
            int num = (int) Math.sqrt(i);
            //如果累计次数num - 1个数相等则为素数
            if (count1 == (num - 1)) {
                System.out.println("素数:" + i);
                count2++;
            }
            // 统计素数个数
            count1 = 0;
        }
        System.out.println(count2);
    }

    @org.junit.Test
    public void test() {
        int a = 0, b = 200;
        int count = 0;
        boolean flag;
       int c = a > 1 ? a  : 2;
        for (int i = c; i <= b; i++) {
            flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
                System.out.println("质数：" + i);
            }
        }
        System.out.println(count);
    }

    int count = 3;
    @org.junit.Test
    public void test2(){
        int a =  100000;
        count += 1;
        System.out.println(count);
        count =+ 1;
        System.out.println(count);
    }
    public int add(int i){
        if (i > 0) {
            count = count + i;
            i--;
            return add(i);
        }else {
            return count;
        }
    }

}