package com.lxy.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}

	/**
	 * 根据名称获取Bean
	 * @param name Bean名称
	 * @return Bean
	 */
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

	/**
	 * 根据Bean名称和类型获取
	 * @param name 名称
	 * @param type 类型
	 */
	public static <T> T getBean(String name, Class<T> type) {
		return applicationContext.getBean(name, type);
	}

	/**
	 * Bean是否存在
	 * @param name Bean名称
	 */
	public static boolean containBean(String name) {
		return applicationContext.containsBean(name);
	}

	/**
	 * 根据Bean类型获取
	 * @param type 类型
	 * @param <T> 泛型
	 * @return Bean
	 */
	public static <T> T getBean(Class<T> type) {
		return applicationContext.getBean(type);
	}
}