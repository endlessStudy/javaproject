package cn.itcast.jk.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.common.springdao.SqlDao;
import cn.itcast.jk.dao.ContractHisDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.pagination.Page;
import cn.itcast.jk.service.ContractHisService;
import cn.itcast.jk.vo.ContractVO;
import cn.itcast.util.UtilFuns;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月20日
 */
@Service
public class ContractHisServiceImpl implements ContractHisService {
	@Resource
	ContractHisDao contractHisDao;
	@Resource
	SqlDao sqlDao;

	public void pigeinhole(String[] contractIds) {
		sqlDao.batchSQL(this.doData(contractIds, "", "_his"));		//批量执行
	}

	public void pigeouthole(String[] contractIds) {
		sqlDao.batchSQL(this.doData(contractIds, "_his", ""));
	}
	
	//处理数据：有源表向目标表复制数据，将源表数据删除
	public String[] doData(String[] contractIds, String source, String target){
		StringBuffer sBuf = new StringBuffer();
		String inStr = UtilFuns.joinStr(contractIds, "'", "'", ",");			//合同的id串 x,y ，构造成in子查询串 'x','y'
		
		sBuf.append("insert into contract").append(target).append("_c (select * from contract").append(source).append("_c where contract_id in (").append(inStr).append("));");
		sBuf.append("insert into contract_product").append(target).append("_c (select * from contract_product").append(source).append("_c where contract_id in (").append(inStr).append("));");
		sBuf.append("insert into ext_cproduct").append(target).append("_c (select * from ext_cproduct").append(source).append("_c where contract_product_id in (select contract_product_id from contract_product").append(source).append("_c where contract_id in (").append(inStr).append(")));");
		
		sBuf.append("delete from ext_cproduct").append(source).append("_c where contract_product_id in (select contract_product_id from contract_product").append(source).append("_c where contract_id in (").append(inStr).append("));");
		sBuf.append("delete from contract_product").append(source).append("_c where contract_id in (").append(inStr).append(");");
		sBuf.append("delete from contract").append(source).append("_c where contract_id in (").append(inStr).append(");");
		
		return sBuf.toString().split(";");
	}

	public List<Contract> findPage(Page page) {
		return contractHisDao.findPage(page);
	}

	public List<Contract> find(Map paraMap) {
		return contractHisDao.find(paraMap);
	}

	public ContractVO view(String contractId) {
		return contractHisDao.view(contractId);
	}

}
