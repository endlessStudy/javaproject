package com.lxy.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * 有效的括号
 * @author tear-smart
 * @date 2020-07-10
 */
public class ValidBracket {
	public static void main(String[] args) {
		System.out.println(isValid("()"));
	}

	public static boolean isValid(String s) {
		if (s == null) {
			return true;
		}
		s = s.replace(" ", "");
		if ("".equals(s)) {
			return true;
		}
		int length = s.length();
		Map<String, String> map = new HashMap<>();
		map.put("(", ")");
		map.put("[", "]");
		map.put("{", "}");
		List<String> charList = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			String c = String.valueOf(s.charAt(i));
			if (map.containsKey(c)) {
				charList.add(map.get(c));
			} else {
				int size = charList.size();
				if (size == 0) {
					return false;
				}
				String lastChar = charList.remove(size);
				if (!lastChar.equals(c)) {
					return false;
				}
			}
		}
		return charList.size() == 0;
	}
}
