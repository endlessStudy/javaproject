package com.lxy.designMode.singleton;

/**
 * Created by liuyl on 2018/3/1.
 * 懒汉模式
 */
public class LazySingleton {
	private static LazySingleton lazySingleton = null;

	private LazySingleton() {
	}

	;

	public static LazySingleton getInstance() {
		if (lazySingleton == null) {
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}
	/**
	 * 双重检查锁定懒汉模式
	 */
    /*public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }*/
}
