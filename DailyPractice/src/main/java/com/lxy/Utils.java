/*
 * @(#)Utils.java 2017年8月9日下午7:28:17
 * api_for_es
 * Copyright 2017 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.lxy;

import java.util.HashMap;

/**
 * Utils
 * @version 1.0
 */
public class Utils {
	//数字位
	public static char[] chnNumChinese = {'零', '一', '二', '三', '四', '五', '六', '七', '八', '九', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖', '两'};
	//节权位
	public static String[] chnUnitSection = {"", "万", "亿", "万亿"};
	//权位
	public static String[] chnUnitChar = {"", "十", "百", "千", "拾", "佰", "仟", "角", "分", "元"};

	public static HashMap<Object, Integer> intMap = new HashMap<Object, Integer>();

	public Utils() {
		init();
	}

	private void init() {
		System.out.println("初始化！");
		int i = 0;
		for (char ch : chnNumChinese) {
			if (ch == '两') {
				intMap.put(ch, 2);
			} else {
				intMap.put(ch, i++);
			}
			if (i == 10) {
				i = 1;
			}
		}
		intMap.put("两", 2);
		intMap.put('十', 10);
		intMap.put('百', 100);
		intMap.put('千', 1000);
		intMap.put('拾', 10);
		intMap.put('佰', 100);
		intMap.put('仟', 1000);
	}

	public static String CNNum2Arb(String CNNumStr) {
		String str1 = new String();
		String str2 = new String();
		String str3 = new String();
		int k = 0;
		boolean dealflag = true;
		for (int i = 0; i < CNNumStr.length(); i++) {//先把字符串中的“零”除去
			if ('零' == (CNNumStr.charAt(i))) {
				CNNumStr = CNNumStr.substring(0, i) + CNNumStr.substring(i + 1);
			}
		}
		String chineseNum = CNNumStr;
		for (int i = 0; i < chineseNum.length(); i++) {
			if (chineseNum.charAt(i) == '亿') {
				str1 = chineseNum.substring(0, i);//截取亿前面的数字，逐个对照表格，然后转换
				k = i + 1;
				dealflag = false;//已经处理
			}
			if (chineseNum.charAt(i) == '万') {
				str2 = chineseNum.substring(k, i);
				str3 = CNNumStr.substring(i + 1);
				dealflag = false;//已经处理
			}
		}
		if (dealflag) {//如果没有处理
			str3 = chineseNum;
		}
		int result = sectionChinese(str1) * 100000000 +
				sectionChinese(str2) * 10000 + sectionChinese(str3);
		return result + "";
	}

	public static int sectionChinese(String str) {

		int value = 0;
		int sectionNum = 0;
		for (int i = 0; i < str.length(); i++) {
			int v = (int) intMap.get(str.charAt(i));
			if (v == 10 || v == 100 || v == 1000) {//如果数值是权位则相乘
				sectionNum = v * sectionNum;
				value = value + sectionNum;
			} else if (i == str.length() - 1) {
				value = value + v;
			} else {
				sectionNum = v;
			}
		}
		return value;
	}

	public static void main(String[] args) {
		Utils utils = new Utils();
		utils.CNNum2Arb("100");
	}
}
