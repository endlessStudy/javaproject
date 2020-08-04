package com.lxy.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by liuyl on 2018/3/12.
 */
public class TypeTranstion {
	private static int getIntProperty(String property, int defaults) {
		if (StringUtils.isBlank(property)) {
			return defaults;
		}
		return Integer.parseInt(property);
	}
}
