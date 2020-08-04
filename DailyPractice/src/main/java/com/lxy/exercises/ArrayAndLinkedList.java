package com.lxy.exercises;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * |****************************** *_* ******************************|
 * |   __                                                      __    |
 * | _/  |_  ____ _____ _______    ______ _____ _____ ________/  |_  |
 * | \   __\/ __ \\__  \\_  __ \  /  ___//     \\__  \\_  __ \   __\ |
 * |  |  | \  ___/ / __ \|  | \/  \___ \|  Y Y  \/ __ \|  | \/|  |   |
 * |  |__|  \___  >____  /__|    /____  >__|_|  (____  /__|   |__|   |
 * |            \/     \/             \/      \/     \/              |
 * |                                                                 |
 * |****************************** *_* ******************************|
 * </p>
 * @author tear-smart
 * @date 2019-03-22
 */
public class ArrayAndLinkedList {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		compare();
	}

	private static void compare() {
		Object obj = new Object();
		List arr = new ArrayList();
		List linked = new LinkedList();
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			arr.add(0, obj);
		}
		System.out.println("ArrayList 插入耗时 : " + (System.currentTimeMillis() - time1));
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			linked.add(0, obj);
		}
		System.out.println("LinkedList 插入耗时 : " + (System.currentTimeMillis() - time2));
	}
}
