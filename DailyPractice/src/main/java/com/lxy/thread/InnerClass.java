package com.lxy.thread;

interface Message {
    void print();
}
class MyMessage implements Message{

    @Override
    public void print() {
        System.out.println("123");
    }
}
/**
 * <p>
 *
 * </p>
 * @author liuyl
 * @date 2018-11-29
 */
public class InnerClass {
    public static void main(String[] args) {
        //创建类 实现接口
        fun(new MyMessage());
        //java8 lamda
        fun2(()->{
            System.out.println("123");
        });
        //匿名内部类
        fun2(new Message() {
            @Override
            public void print() {
                System.out.println("123");
            }
        });
    }
    public static void fun(MyMessage message) {
        message.print();
    }
    public static void fun2(Message message) {
        message.print();
    }
}

