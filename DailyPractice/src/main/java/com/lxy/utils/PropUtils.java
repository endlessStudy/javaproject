package com.lxy.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by liuyl on 2018/3/21.
 */
public class PropUtils {
	private static Properties properties;

	public PropUtils(String path) {
		InputStream fis = RedisUtil.class.getClassLoader().getResourceAsStream(path);
		properties = new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Properties getProperties(String path) {
		new PropUtils(path);
		return properties;
	}

	public static String getProperties(String path, String string) {

		return properties.getProperty(string);
	}
}
