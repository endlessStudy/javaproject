package com.lxy;

/**
 * Created by liuyl on 2017/12/22.
 */
public class SortDetail {
    public static void main(String[] args) {
        short s1 = 1;
        //s1 = s1 + 1;
        short s2 = 1;
        s2 += 1;
        System.out.println(s2);
        float f1 = 3.2f;
        System.out.println(f1*0.1);
        //Long 缓存 -128 - 127之间
        Long l1 = 128L;
        Long ll2 = 128L;
        System.out.println(l1 == 128L);
        String str= "123";
        str = "456";
        System.out.println(str);

    }
}
