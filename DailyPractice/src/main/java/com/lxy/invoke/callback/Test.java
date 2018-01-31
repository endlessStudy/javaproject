package com.lxy.invoke.callback;

/**
 * Created by liuyl on 2018/1/16.
 */
public class Test {
    public static void main(String[] args) {
        Li li = new Li();
        Wang wang = new Wang(li);
        wang.askQuestion("1 + 1 = ？");
    }
}
