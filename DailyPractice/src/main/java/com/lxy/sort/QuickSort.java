package com.lxy.sort;

/**
 * <p>
 *
 * </p>
 * @author liuyl
 * @date 2018-11-26
 */
public class QuickSort {

    public static int[] quickSort(int[] arr, int left, int right) {
        int len = arr.length, partitionIndex;
        if (left < right) {
            partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    // 分区操作
    public static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left,
                index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
