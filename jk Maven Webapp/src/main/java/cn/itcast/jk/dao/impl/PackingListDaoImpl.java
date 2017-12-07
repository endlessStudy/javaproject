package cn.itcast.jk.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.PackingListDao;
import cn.itcast.jk.domain.PackingList;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
@Repository
public class PackingListDaoImpl extends BaseDaoImpl<PackingList> implements PackingListDao{
	public PackingListDaoImpl() {
		//设置命名空间
		super.setNs("cn.itcast.jk.mapper.PackingListMapper");
	}

	public void updateState(Map map) {
		super.getSqlSession().update(super.getNs()+".updateState", map);
	}
}
