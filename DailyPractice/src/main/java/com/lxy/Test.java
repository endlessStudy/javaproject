package com.lxy;

import org.apache.commons.lang3.ArrayUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liuyl on 2018/1/31.
 */
public class Test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("first","1");
        map.put("second","2");
        map.put("third","3");
        for (Map.Entry<String,String> enMap : map.entrySet()){
            System.out.println(enMap.getKey()+"  :  "+ enMap.getValue());
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    }
}