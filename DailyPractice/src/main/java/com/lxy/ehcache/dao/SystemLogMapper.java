package com.lxy.ehcache.dao;

import com.lxy.ehcache.entity.SystemLog;

/**
 * Created by liuyl on 2018/1/12.
 */
public interface SystemLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(SystemLog record);

    int insertSelective(SystemLog record);

    SystemLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SystemLog record);

    int updateByPrimaryKey(SystemLog record);

    int count();
}
