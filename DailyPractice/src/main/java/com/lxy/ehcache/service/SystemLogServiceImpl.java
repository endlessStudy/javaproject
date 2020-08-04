package com.lxy.ehcache.service;

import com.lxy.ehcache.dao.SystemLogMapper;
import com.lxy.ehcache.entity.SystemLog;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liuyl on 2018/1/12.
 */
@Service("systemLogService")
public class SystemLogServiceImpl implements SystemLogService {
	@Resource
	private SystemLogMapper systemLogMapper;

	@Override
	public int deleteSystemLog(String id) {
		return systemLogMapper.deleteByPrimaryKey(id);
	}

	@Override
	//@CachePut(value="myCache")
	//@CacheEvict(value="myCache",allEntries=true,beforeInvocation=true)
	@CacheEvict(value = "myCache", key = "0", beforeInvocation = true)
	public int insert(SystemLog record) {
		return systemLogMapper.insertSelective(record);
	}

	@Override
	@Cacheable(value = "myCache", key = "#id")
	public SystemLog findSystemLog(String id) {
		return systemLogMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateSystemLog(SystemLog record) {
		return systemLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int insertTest(SystemLog record) {
		return systemLogMapper.insert(record);
	}

	@Override
	@Cacheable(value = "myCache", key = "0")
	public int count() {
		int num = systemLogMapper.count();
		return num;
	}
}
