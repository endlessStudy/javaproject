package com.liuyl.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by liuyl on 2017/9/30.
 */
public class FileUtils {
    public static void main(String[] args) throws IOException {
        String str = org.apache.commons.io.FileUtils.readFileToString(new java.io.File("F:\\worksplace\\vue\\resource\\json.json"),"UTF-8");
        JSONObject jsonObject = JSONArray.parseObject(str);
        JSONArray jsonArray = jsonObject.getJSONArray("buckets");
        Object[] arr = jsonArray.toArray();
        Map<Object,Object> map;
        for (Object obj : arr){
            map = (Map)obj;
            System.out.println(map.get("key")+"\t"+map.get("doc_count"));
        }
    }
}
