package com.lxy.designMode.singleton;

/**
 * Created by liuyl on 2018/3/1.
 * 饿汉模式
 */
public class HungerSingleton {
    private static final HungerSingleton hungerSingleton = new HungerSingleton();
    private HungerSingleton(){};
    public static HungerSingleton getInstance(){
        return hungerSingleton;
    }
}
