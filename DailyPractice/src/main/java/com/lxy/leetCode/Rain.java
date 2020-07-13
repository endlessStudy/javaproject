package com.lxy.leetCode;

import java.util.Stack;

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
 * @date 2020-07-13
 */
public class Rain {

	public static int trap(int[] height) {
		int max = 0;
		int count = 0;
		int sum = 0;
		int pre = 0;
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < height.length; i++) {
			int data = height[i];
			if (count == 0 && data == 0) {
				continue;
			}
			if (data < pre) {
				count++;
				sum += data;
			} else if (data == pre) {
				if (count != 0) {
					count++;
				}
			} else {
				sum += data;
				if (data > max) {
					max = data;
				}
				if (count != 0) {
					sum -= Math.abs(data - max);
					result += sum - (max * count);
					max = 0;
					count = 0;
					sum = 0;
				}
			}
			pre = data;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(arr));
	}
}
