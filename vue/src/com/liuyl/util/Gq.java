package com.liuyl.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.io.*;
import org.apache.commons.lang3.math.NumberUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.security.Provider;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by liuyl on 2017/9/30.
 */
public class Gq {
    private static Logger logger = LoggerFactory.getLogger(Gq.class);
    private static Map<String,String> map = new HashMap();
    private static String[] sf = {"山东", "江苏", "河南", "河北", "浙江", "上海", "广东", "湖北", "安徽", "四川", "湖南", "辽宁", "北京", "陕西", "吉林", "江西", "广西", "重庆", "内蒙古", "天津", "福建", "山西", "黑龙江", "贵州", "云南", "甘肃", "新疆", "宁夏", "青海", "西藏", "海南"};
    //private static String[] sf ={"内蒙古"};
    private static Client esClient = null;
    private static String clusterName = "HYYD_1_7";
    private static int port = 9301;
    private static int[] result = new int[5];
    private static Map<String,int[]> rsMap = new HashMap <String,int[]>();
    public static void main(String[] args) {
        map.put("11","北京");
        map.put("12","天津");
        map.put("13","河北");
        map.put("14","山西");
        map.put("15","内蒙古");
        map.put("21","辽宁");
        map.put("22","吉林");
        map.put("23","黑龙江 ");
        map.put("31","上海");
        map.put("32","江苏");
        map.put("33","浙江");
        map.put("34","安徽");
        map.put("35","福建");
        map.put("36","江西");
        map.put("37","山东");
        map.put("41","河南");
        map.put("42","湖北");
        map.put("43","湖南");
        map.put("44","广东");
        map.put("45","广西");
        map.put("46","海南");
        map.put("50","重庆");
        map.put("51","四川");
        map.put("52","贵州");
        map.put("53","云南");
        map.put("54","西藏");
        map.put("61","陕西");
        map.put("62","甘肃");
        map.put("63","青海");
        map.put("64","宁夏");
        map.put("65","新疆");
        map.put("71","台湾");
        map.put("81","香港");
        map.put("82","澳门");
        long start = System.currentTimeMillis();
        Settings settings = ImmutableSettings.builder().put("cluster.name", clusterName).put("client.transport.sniff", true).build();
        esClient = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress("172.16.124.8", port));
        String query = readJson();
        //System.out.println(query);
        SearchResponse sResponse = esClient.prepareSearch("writ_stick_4cpwsw").setTypes("fycase").setSearchType(SearchType.SCAN).
                setScroll(TimeValue.timeValueMinutes(10000)).setSource(query).execute().actionGet();
        long total = sResponse.getHits().getTotalHits();
        System.out.println("查询" + sResponse.getHits().getTotalHits() + "条数据,用时" + (System.currentTimeMillis() - start) + "毫秒");
        int sum = 0;
        String cmssd = null;
        String jand = null;
        String ajjbqk = null;
        String sf = null;
        JSONObject jsonObject = null;
        int count = 0;
        while (count < total) {
            sResponse = esClient.prepareSearchScroll(sResponse.getScrollId()).setScroll(new TimeValue(2000)).get();
            for (SearchHit hit : sResponse.getHits()) {
                count++;
                jsonObject = JSONObject.parseObject(hit.getSourceAsString());
                try {
                    cmssd = (String) jsonObject.getJSONObject("QW").getJSONObject("AJJBQK").getJSONObject("CMSSD").get("@value");
                } catch (Exception e) {
                    if ("java.lang.NullPointerException".equals(e.getClass().getName())){
                        logger.error("CMSSD异常........."+e.getClass().getName());
                    }else {
                        JSONArray jsonArray = jsonObject.getJSONObject("QW").getJSONObject("AJJBQK").getJSONArray("CMSSD");
                        for (Object arr:jsonArray){
                            JSONObject obJe = (JSONObject) arr;
                            cmssd += obJe.getString("@value");
                        }
                    }
                }
                try {
                    ajjbqk = (String) jsonObject.getJSONObject("QW").getJSONObject("AJJBQK").get("@value");
                    sf = (String) jsonObject.getJSONObject("QW").getJSONObject("WS").getJSONObject("JBFY").getJSONObject("XZQH_P").get("@value");
                    jand = (String) jsonObject.getJSONObject("QW").getJSONObject("WW").getJSONObject("CPSJ").getJSONObject("JAND").get("@value");
                }catch (Exception e){
                    logger.error("JAND异常........."+e.getClass().getName());
                    continue;
                }
                if ( cmssd.contains("死") || cmssd.contains("亡")) {
                    int[] arr = new int[5];
                    if (rsMap.containsKey(sf)){
                        arr = rsMap.get(sf);
                        arr[Integer.valueOf(jand)-2012]++;
                        rsMap.put(sf,arr);
                    }else {
                        arr[Integer.parseInt(jand)-2012]++;
                        rsMap.put(sf,  arr);
                    }

                }else if (ajjbqk.contains("死") || ajjbqk.contains("亡")){
                    int[] arr = new int[5];
                    if (rsMap.containsKey(sf)){
                        arr = rsMap.get(sf);
                        arr[Integer.valueOf(jand)-2012]++;
                        rsMap.put(sf,arr);
                    }else {
                        arr[Integer.parseInt(jand)-2012]++;
                        rsMap.put(sf,  arr);
                    }
                }
            }

            logger.info("已完成=="+count);

        }
        for (Map.Entry<String,int[]> entry : rsMap.entrySet()){
            System.out.println(entry.getKey()+"\t"+Arrays.toString(entry.getValue()));
        }
    }
    public static List getSfzhm(JSONObject jsonObject){
        List list = new ArrayList<>();
        Map map = jsonObject;
        String type = map.get("YSF").getClass().toString().substring(27);
        if (type.equals("JSONArray")) {
            JSONArray ysfArray = jsonObject.getJSONArray("YSF");
            for (Object ob : ysfArray) {
                JSONObject ysfEntity = (JSONObject) ob;
                list.add(ysfEntity.getJSONObject("ZJLX").getJSONObject("ZJHM").get("@value").toString().substring(0,1));
            }
        } else if (type.equals("JSONObject")) {
            list.add(jsonObject.getJSONObject("YSF").getJSONObject("ZJLX").getJSONObject("ZJHM").get("@value").toString().substring(0,1));
        }
        return list;
    }
    public static String sfzhm(String hm){
        String dqdm = hm.substring(0,1);
        return map.get(dqdm);
    }
    public static String readJson() {
        try {
            return org.apache.commons.io.FileUtils.readFileToString(new File("F:\\worksplace\\vue\\resource\\dljt.json"), "UTF-8");
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
            return null;
        }
    }
}
