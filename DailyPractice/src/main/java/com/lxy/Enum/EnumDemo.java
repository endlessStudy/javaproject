package com.lxy.Enum;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 * @author liuyl
 * @date 2018-11-28
 */
public class EnumDemo {
	public static void main(String[] args) {
		Arrays.stream(Color.values()).forEach(item -> {
			System.out.println(item.ordinal() + " : " + item.name() + " : " + item.getTitle());
		});
	}
}

/**
 * 枚举类
 */
enum Color {
	RED("红色"), YELLOW("黄色"), BLUE("蓝色");
	/**
	 * 标题
	 */
	private String title;

	private Color(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
