package com.test;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuyl on 2017/9/14.
 */
public class ProvinceJudge {
    private static String[] hbPro = {"河北", "石家庄", "长安", "桥西", "新华", "井陉矿", "裕华",
            "藁城", "鹿泉", "栾城", "井陉", "正定", "行唐", "灵寿", "高邑", "深泽", "赞皇",
            "无极", "平山", "元氏", "赵", "晋州", "新乐", "唐山", "路南", "路北", "古冶",
            "开平", "丰南", "丰润", "曹妃甸", "滦", "滦南", "乐亭", "迁西", "玉田", "遵化",
            "迁安", "秦皇岛", "海港", "山海关", "北戴河", "抚宁", "青龙满族自治", "昌黎", "卢龙",
            "邯郸", "邯山", "丛台", "复兴", "峰峰矿", "邯郸", "临漳", "成安", "大名", "涉", "磁",
            "肥乡", "永年", "邱", "鸡泽", "广平", "馆陶", "魏", "曲周", "武安", "邢台", "桥东", "桥西",
            "邢台", "临城", "内丘", "柏乡", "隆尧", "任", "南和", "宁晋", "巨鹿", "新河", "广宗", "平乡",
            "威", "清河", "临西", "南宫", "沙河", "保定", "竞秀", "莲池", "满城", "清苑", "徐水", "涞水", "阜平",
            "定兴", "唐", "高阳", "容城", "涞源", "望都", "安新", "易", "曲阳", "蠡", "顺平", "博野", "雄", "涿州",
            "安国", "高碑店", "张家口", "桥东", "桥西", "宣化", "下花园", "万全", "崇礼", "张北", "康保", "沽源", "尚义",
            "蔚", "阳原", "怀安", "怀来", "涿鹿", "赤城", "承德", "双桥", "双滦", "鹰手营子矿", "承德", "兴隆", "平泉", "滦平",
            "隆化", "丰宁满族自治", "宽城满族自治", "围场满族蒙古族自治", "沧州", "新华", "运河", "沧", "青", "东光", "海兴", "盐山", "肃宁",
            "南皮", "吴桥", "献", "孟村回族自治", "泊头", "任丘", "黄骅", "河间", "廊坊", "安次", "广阳", "固安", "永清", "香河", "大城",
            "文安", "大厂回族自治", "霸州", "三河", "衡水", "桃城", "冀州", "枣强", "武邑", "武强", "饶阳",
            "安平", "故城", "景", "阜城", "深州", "定州", "辛集",};
    private static String[] tjPro = {"天津", "和平", "河东", "河西", "南开", "河北", "红桥", "东丽", "西青", "津南", "北辰", "武清", "宝坻", "滨海新", "宁河", "静海", "蓟州"};
    private static String[] bjPro = {"东城", "西城", "朝阳", "丰台", "石景山", "海淀", "门头沟", "房山", "通州", "顺义", "昌平", "大兴", "怀柔", "平谷", "密云", "延庆"};
    private static List <String> tjProList = Arrays.asList(tjPro);
    private static List <String> bjProList = Arrays.asList(bjPro);
    private static List <String> hbProList = Arrays.asList(hbPro);
    private static int index = 0;
    public static void main(String[] args) {
        String url = "jdbc:postgresql://172.16.32.221/fb09_hn";
        String username = "artbase";
        String password = "123456";
        String urlIns = "jdbc:postgresql://172.16.32.221/fb09_hn";
        String usernameIns = "artbase";
        String passwordIns = "123456";

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            Connection conn =  DriverManager.getConnection(url, username, password);
            String querySQL = "";
            //查询数据
            ResultSet rs = conn.prepareStatement(querySQL).executeQuery();
            while (rs.next()){
                rs.getString("lx");
                rs.getString("");
                rs.getString("");
                rs.getString("");
                rs.getString("");
                rs.getString("");
            }
            //插入处理过之后的数据
            Connection connIns =  DriverManager.getConnection(urlIns, usernameIns, passwordIns);
            String sql = "";
            PreparedStatement psIns = connIns.prepareStatement(sql);

            if (index > 5000){
                psIns.addBatch();
            };
            psIns.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }

        proJudge("");


    }

    public static String proJudge(String dz) {
        if (dz.contains("市")) {
            return dz.substring(0, dz.indexOf("市") + 1);
        } else if (dz.contains("区")) {
            return dz.substring(0, dz.indexOf("区") + 1);
        } else if (dz.contains("县")) {
            return dz.substring(0, dz.indexOf("县") + 1);
        }else if(dz.contains("首都")){

        }
        return null;
    }

    public static void proJudge1(String dq) {
        if (tjProList.contains(dq)) {

        }else if (bjProList.contains(dq)){

        }else{

        }
    }

    public static void insertData(Connection conn) throws Exception {
        conn.prepareStatement("");
    }
}
