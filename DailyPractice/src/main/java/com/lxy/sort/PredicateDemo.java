package com.lxy.sort;

import java.util.function.Predicate;

/**
 * <p>
 *
 * </p>
 * @author liuyl
 * @date 2018-11-27
 */
public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> preDestroy = age -> age > 18;
        boolean test = preDestroy.test(19);
        System.out.println(test);
    }
}
