package cn.itcast.jk.dao.impl;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.OutProductDao;
import cn.itcast.jk.vo.OutProductVO;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
@Repository
public class OutProductDaoImpl extends BaseDaoImpl<OutProductVO> implements OutProductDao{
	public OutProductDaoImpl() {
		//设置命名空间
		super.setNs("cn.itcast.jk.mapper.OutProductMapper");
	}
}
