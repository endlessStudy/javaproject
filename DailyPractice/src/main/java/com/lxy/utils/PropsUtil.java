package com.lxy.utils;

import java.util.ResourceBundle;

/**
 * propsUtil
 * @version 1.0
 */
public class PropsUtil {
	private static ResourceBundle bundle = ResourceBundle.getBundle(CacheContans.CONFIG_NAME);

	public static String getConfigKey(String key) {
		return bundle.getString(key);
	}
}