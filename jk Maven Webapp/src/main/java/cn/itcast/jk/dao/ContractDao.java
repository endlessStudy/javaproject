package cn.itcast.jk.dao;

import java.util.Map;

import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.vo.ContractVO;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
public interface ContractDao extends BaseDao<Contract> {
	public void updateState(Map map);			//修改状态
	public ContractVO view(String contractId);	//查询某个合同
}
