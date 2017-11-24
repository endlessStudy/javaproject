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
public class xcdj {
    private static Logger logger = LoggerFactory.getLogger(Gq.class);
    private static Map<String,String> map = new HashMap();
    private static String[] sf = {"山东", "江苏", "河南", "河北", "浙江", "上海", "广东", "湖北", "安徽", "四川", "湖南", "辽宁", "北京", "陕西", "吉林", "江西", "广西", "重庆", "内蒙古", "天津", "福建", "山西", "黑龙江", "贵州", "云南", "甘肃", "新疆", "宁夏", "青海", "西藏", "海南"};
    //private static String[] sf ={"内蒙古"};
    private static Client esClient = null;
    private static String clusterName = "HYYD_1_7";
    private static int port = 9301;
    private static int[] result = new int[6];
    private static Map<String,int[]> rsMap = new HashMap <String,int[]>();

    public static void main(String[] args) {
        rsMap.put("2012",new int[6]);
        rsMap.put("2013",new int[6]);
        rsMap.put("2014",new int[6]);
        rsMap.put("2015",new int[6]);
        rsMap.put("2016",new int[6]);
        long start = System.currentTimeMillis();
        Settings settings = ImmutableSettings.builder().put("cluster.name", clusterName).put("client.transport.sniff", true).build();
        esClient = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress("172.16.124.8", port));
        Executor executor = Executors.newFixedThreadPool(10);
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
            if (sResponse.getHits().getHits().length == 0){
                break;
            }
            for (SearchHit hit : sResponse.getHits()) {
                count++;
                jsonObject = JSONObject.parseObject(hit.getSourceAsString());
                try {
                    cmssd = (String) jsonObject.getJSONObject("QW").getJSONObject("AJJBQK").getJSONObject("CMSSD").get("@value");
                    jand = (String) jsonObject.getJSONObject("QW").getJSONObject("WW").getJSONObject("CPSJ").getJSONObject("JAND").get("@value");
                }catch (Exception e){
                }
                if(cmssd.contains("电动车") ){
                    int[] arr  = rsMap.get(jand);
                    arr[0]++;
                    rsMap.put(jand,  arr);
                }
                if(cmssd.contains("电动三轮车")){
                    int[] arr  = rsMap.get(jand);
                    arr[1]++;
                    rsMap.put(jand,  arr);
                }
                if(cmssd.contains("自行车") && !cmssd.contains("电动自行车")){
                    int[] arr  = rsMap.get(jand);
                    arr[2]++;
                    rsMap.put(jand,  arr);
                }
                if(cmssd.contains("老年代步车")){
                    int[] arr  = rsMap.get(jand);
                    arr[3]++;
                    rsMap.put(jand,  arr);
                }
                if(cmssd.contains("三轮车")&& !cmssd.contains("电动三轮车")){
                    int[] arr = rsMap.get(jand);
                    arr[4]++;
                    rsMap.put(jand,  arr);
                }
                if(cmssd.contains("电动自行车")){
                    int[] arr = rsMap.get(jand);
                    arr[5]++;
                    rsMap.put(jand,  arr);
                }

            }
            logger.info("已完成=="+count);

        }
        for (Map.Entry<String,int[]> entry : rsMap.entrySet()){
            System.out.println(entry.getKey()+"\t"+Arrays.toString(entry.getValue()));
        }
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
