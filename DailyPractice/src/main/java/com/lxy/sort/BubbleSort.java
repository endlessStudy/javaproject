package com.lxy.sort;

/**
 * <p>
 *
 * </p>
 * @author liuyl
 * @date 2018-11-26
 */
public class BubbleSort {
	public static int[] sort(int[] ints) {
		int len = ints.length;
		int flag = len;
		//如果flag>0则排序结束
		while (flag > 0) {
			flag = 0;
			for (int i = 1; i < len; i++) {
				//前面大于后面则交换数据
				if (ints[i - 1] > ints[i]) {
					int temp = ints[i];
					ints[i] = ints[i - 1];
					ints[i - 1] = temp;
					//设置最新边界
					flag = i;
				}
			}
			//记录遍历的边界
			len = flag;
		}
		return ints;
	}

	public static int[] bubbleSort(int[] ints) {
		int len = ints.length;
		for (int i = 0; i < len; i++) {
			for (int j = 1; j < len - i; j++) {
				if (ints[j - 1] > ints[j]) {
					int temp = ints[j];
					ints[j] = ints[j - 1];
					ints[j - 1] = temp;
				}
			}
		}
		return ints;
	}

	public static int[] bubbleSort2(int[] ints) {
		int len = ints.length;
		int flag = len;
		while (flag > 0) {//如果flag>0则排序结束
			flag = 0;
			for (int i = 1; i < len; i++) {
				if (ints[i - 1] > ints[i]) { //前面大于后面则交换数据
					int temp = ints[i];
					ints[i] = ints[i - 1];
					ints[i - 1] = temp;
					flag = i; //设置最新边界
				}
			}
			len = flag;//记录遍历的边界
		}
		return ints;
	}
}
