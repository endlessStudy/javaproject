package com.lxy.commons;


/**
 * Created by liuyl on 2018/2/2.
 */
public class BeanUtilsCommons {
	public static void main(String[] args) {
		int i = 0;
		for (foo('A'); foo('B') && (i < 2); foo('C')) {
			i++;
			foo('D');
		}
	}

	public static boolean foo(char c) {
		System.out.print(c);
		return true;
	}
}
