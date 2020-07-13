package com.lxy.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;

/**
 * <p>
 *
 * </p>
 * @author liuyl
 * @date 2018-11-26
 */
@Slf4j
public class Test {

     public static void main(String[] args) {
         Random random = new Random();
        int[] ints = new int[10000];
         log.info("11111");
        for (int i = 0; i < 10000; i++) {
            ints[i] = random.nextInt(10000000);
        }
        // int[] ints1 = Arrays.copyOf(ints, 10000);
        System.out.println(Arrays.toString(ints));

        long start = System.currentTimeMillis();
         // int[] resout = BubbleSort.bubbleSort(ints);
         // int[] resout = BubbleSort.sort(ints);
         // int[] resout = BubbleSort.bubbleSort2(ints);
         int[] resout = QuickSort.quickSort(ints, 0, ints.length - 1);
         System.out.println("双重循环bubbleSort　：" + (System.currentTimeMillis() - start));
         System.out.println(Arrays.toString(resout));

    }
}
