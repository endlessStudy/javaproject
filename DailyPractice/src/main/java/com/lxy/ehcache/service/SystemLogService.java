package com.lxy.ehcache.service;

import com.lxy.ehcache.entity.SystemLog;

/**
 * Created by liuyl on 2018/1/12.
 */
public interface SystemLogService {

	int deleteSystemLog(String id);

	int insert(SystemLog record);

	int insertTest(SystemLog record);

	SystemLog findSystemLog(String id);

	int updateSystemLog(SystemLog record);

	int count();
}