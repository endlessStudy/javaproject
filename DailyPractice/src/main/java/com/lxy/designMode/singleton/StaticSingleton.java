package com.lxy.designMode.singleton;

/**
 * Created by liuyl on 2018/3/1.
 * 静态内部类方法
 */
public class StaticSingleton {
	private static class LoadSingleton {
		private static StaticSingleton staticSingleton = new StaticSingleton();
	}

	private StaticSingleton() {
	}

	;

	public static StaticSingleton getInstance() {
		return LoadSingleton.staticSingleton;
	}
}
