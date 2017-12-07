package cn.itcast.jk.dao.impl;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.ExportProductDao;
import cn.itcast.jk.domain.ExportProduct;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
@Repository
public class ExportProductDaoImpl extends BaseDaoImpl<ExportProduct> implements ExportProductDao{
	public ExportProductDaoImpl() {
		//设置命名空间
		super.setNs("cn.itcast.jk.mapper.ExportProductMapper");
	}
}
