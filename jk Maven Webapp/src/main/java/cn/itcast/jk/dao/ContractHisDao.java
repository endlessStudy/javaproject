package cn.itcast.jk.dao;

import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.vo.ContractVO;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
public interface ContractHisDao extends BaseDao<Contract> {
	public ContractVO view(String contractId);	//查询某个合同
}
