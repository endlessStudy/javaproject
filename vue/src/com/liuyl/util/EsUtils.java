package com.liuyl.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liuyl on 2017/9/26.
 */
public class EsUtils {
    private static Map<String,String> map = new HashMap();
    private static Logger logger = LoggerFactory.getLogger(EsUtils.class);
    private static Client esClient = null;
    private static String clusterName = "HYYD_1_7";
    private static int port = 9301;
    static String[] sgyy1 = {".*(未按规定让行|未避让|未减速|未让直行车辆先行).*", ".*(违反交通信号|闯红灯|信号灯为红灯).*", ".*(酒后*驾驶|醉酒驾驶).*", ".*(无证*驾驶).*", ".*(超速|未确保安全车速).*", ".*(倒车时).*", ".*(未戴安全帽).*", ".*(未年检).*", ".*(未登记).*", ".*(违法变道).*", ".*(超载).*", ".*(吸毒后|毒驾).*", ".*(疲劳驾驶).*", ".*(因*手机|因*电话|行驶过程中接听电话).*", ".*(操作不当).*"};
    static String[] sgyy2 = {".*(因*下雨*滑|由*下雨*滑|有雨|路面潮湿).*"};
    static String[] sgyy ={".*(未戴安全帽).*"};
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
        SearchResponse sResponse = esClient.prepareSearch("writ_stick_4cpwsw").setTypes("fycase").setSearchType(SearchType.SCAN).setScroll(TimeValue.timeValueMinutes(1)).setSource(readJson()).execute().actionGet();
        long count = sResponse.getHits().getTotalHits();
        System.out.println("查询" + sResponse.getHits().getTotalHits() + "条数据,用时" + (System.currentTimeMillis() - start) + "毫秒");
        int sum = 1;
        int i = 1;
        int[] arr1 = new int[sgyy.length];
        int[] arr = new int[123];
        while (sum <= count) {
            sResponse = esClient.prepareSearchScroll(sResponse.getScrollId()).setScroll(new TimeValue(200)).get();
            JSONObject jsonObject = null;
            String cmssd;
            for (SearchHit hit : sResponse.getHits()) {
                sum++;
                jsonObject = JSONObject.parseObject(hit.getSourceAsString());
                try {
                    cmssd = jsonObject.getJSONObject("QW").getJSONObject("AJJBQK").getJSONObject("CMSSD") .getString("@value");
                }catch (Exception e){
                    continue;
                }
               /* for (int j = 0; j < sgyy.length; j++){
                    Pattern patter = Pattern.compile(sgyy[j]);
                    Matcher matcher = patter.matcher(cmssd);
                    if (matcher.matches()){
                       logger.info( jsonObject.getJSONObject("QW").getJSONObject("WS").getJSONObject("AH") .getString("@value"));
                       arr[j]++;
                    }
                }*/
               //事故发生时间月
               //arr[monthReg(cmssd)]++;
                //事故发生时间时
                arr[sgfssjAmReg(cmssd)]++;
            }
            i++;
        }
        for (int rs : arr){
            System.out.println(rs);
        }
       logger.info ("共用时:" + (double)(System.currentTimeMillis() - start)/1000+"秒");
    }
    /*
       * 事故发生时间: 时 包含下午
       */
    public static int sgfssjAmReg(String context) {
        Pattern patterAm = Pattern.compile("下午[0-9]{1,2}时");
        Matcher matcherAm = patterAm.matcher(context);
        Pattern patter = Pattern.compile("[0-9]{1,2}时");
        Matcher matcher = patter.matcher(context);
        int count = 0;
        if (matcherAm.find()) {
            count = Integer.valueOf(matcherAm.group().replace("下午", "").replace("时", ""));
            if (count <= 12) {
                count +=12;
            }
        }else if (matcher.find()) {
            count =  Integer.valueOf(matcher.group().replace("时", ""));
        }else {
            count = 23;
        }
        if (count>=24) {
            count =24 ;
        }
        return count;
    }
    /*
     * 事故发生时间: 月
     */
    public static int monthReg(String context) {
        Pattern patterMonth = Pattern.compile("[0-9]{1,2}月");
        Matcher matcherMonth = patterMonth.matcher(context);
        if (matcherMonth.find()) {
            int month = Integer.valueOf(matcherMonth.group().replace("月", ""));
            if (month > 12) {
                month = 0;
            }
            return month;
        }else {
            return 0;
        }
    }
    /*
    *
     */

    public static String readJson() {
        try {
            return FileUtils.readFileToString(new File("F:\\worksplace\\vue\\resource\\dljt.json"), "UTF-8");
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
            return null;
        }
    }
}
