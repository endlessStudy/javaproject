package cn.itcast.jk.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.ContractProductDao;
import cn.itcast.jk.domain.ContractProduct;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
@Repository
public class ContractProductDaoImpl extends BaseDaoImpl<ContractProduct> implements ContractProductDao{
	public ContractProductDaoImpl() {
		//设置命名空间
		super.setNs("cn.itcast.jk.mapper.ContractProductMapper");
	}

	public void deleteByContractProductById(Serializable[] ids) {
		super.getSqlSession().delete(super.getNs()+".deleteByContractProductById", ids);
	}
	
	public void deleteByContractId(Serializable[] ids){
		super.getSqlSession().delete(super.getNs()+".deleteByContractId", ids);
	}

}
