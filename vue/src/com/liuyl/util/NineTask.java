package com.liuyl.util;

import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.search.SearchHit;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by liuyl on 2017/10/9.
 */
public class NineTask extends BaseData{
    private static String[] sf = {"山东", "江苏", "河南", "河北", "浙江", "上海", "广东", "湖北", "安徽", "四川", "湖南", "辽宁", "北京", "陕西", "吉林", "江西", "广西", "重庆", "内蒙古", "天津", "福建", "山西", "黑龙江", "贵州", "云南", "甘肃", "新疆", "宁夏", "青海", "西藏", "海南"};
    //private static String[] sf ={"内蒙古"};
    private static Client esClient = null;
    private static int port = 9301;
    private static int[] result = new int[sf.length];

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        String clusterName = "HYYD_1_7";
        Settings settings = ImmutableSettings.builder().put("cluster.name", clusterName).put("client.transport.sniff", true).build();
        esClient = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress("172.16.124.8", port));
        Executor executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < sf.length; i++) {
            final int time = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    String query = readJson().replaceAll("sf", sf[time]);
                    //System.out.println(query);
                    SearchResponse sResponse = esClient.prepareSearch("writ_stick_4cpwsw").setTypes("fycase").setSearchType(SearchType.SCAN).
                            setScroll(TimeValue.timeValueMinutes(1)).setSource(query).execute().actionGet();
                    long total = sResponse.getHits().getTotalHits();
                    //System.out.println(sf[time]+"查询" + sResponse.getHits().getTotalHits() + "条数据,用时" + (System.currentTimeMillis() - start) + "毫秒");
                    int sum = 0;
                    String cpfxgc = null;
                    JSONObject jsonObject = null;
                    int count = 0;
                    while (count < total) {
                        sResponse = esClient.prepareSearchScroll(sResponse.getScrollId()).setScroll(new TimeValue(2000)).get();
                        for (SearchHit hit : sResponse.getHits()) {
                            count++;
                            jsonObject = JSONObject.parseObject(hit.getSourceAsString());
                            try {
                                cpfxgc = (String) jsonObject.getJSONObject("QW").getJSONObject("CPFXGC").get("@value");
                            } catch (Exception e) {
                            }
                            if (cpfxgc.contains("误工费") && cpfxgc.contains("农村居民纯收入")) {
                                result[time] += 1;
                            }
                            //System.out.println(sf[time] + "处理了" + count + "数据!");
                        }

                    }
                    System.out.println(sf[time] + "\t" + total + "\t" + result[time]);
                }
            });
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
