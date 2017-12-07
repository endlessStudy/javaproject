package cn.itcast.jk.dao;

import java.io.Serializable;
import java.util.Map;

import cn.itcast.jk.domain.ContractProduct;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
public interface ContractProductDao extends BaseDao<ContractProduct> {
	public void deleteByContractProductById(Serializable[] ids);
	public void deleteByContractId(Serializable[] ids);
}
