package com.lxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuyl on 2018/1/31.
 */

public class Test {
	public static final int PARAM = 1;

	public Test() {
		System.out.print("默认构造方法！--");
	}

	//非静态代码块
	{
		System.out.print("非静态代码块！--");
	}

	//静态代码块
	static {
		System.out.print("静态代码块！--");
	}

	public static void test() {
		System.out.print("静态方法中的内容! --");
		{
			System.out.print("静态方法中的代码块！--");
		}

	}

	public static void main(String[] args) {
		// Test test = new Test();
		Test.test();//静态代码块！--静态方法中的内容! --静态方法中的代码块！--
		// test.test();
		List<String> list = new ArrayList<>();
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		int[] targetArr = new int[4];
		System.arraycopy(arr, 1, targetArr, 0, targetArr.length);
		Arrays.stream(targetArr).forEach(System.out::print);

	}
}