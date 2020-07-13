package com.lxy.exercises;

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
 * @date 2019-03-25
 */
public class ClassLoaderTest {
    static  {
        Java java ;
        System.out.println("C");
    }
    public static void main(String[] args) throws Exception {
        Class j1 ;
        Class j2 ;
        Class j3 ;
        j1 = Java.class;
        System.out.println("1111111111");
        j2 = Class.forName("com.lxy.exercises.Java");
        System.out.println("2222222222");
        Java java = new Java();
        System.out.println("3333333333");
        j3 = java.getClass();
        if (j1 == j2 && j1 == j3) {
            System.out.println("D");
        }else {
            System.out.println("E");
        }
        System.out.println(Java.count);
    }
}
class Java{
    static int count = 0;
    static {
        count++;
        System.out.println("A");
    }
    public Java(){
        System.out.println("B");
    }
}

