package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.ContractDao;
import cn.itcast.jk.dao.ExportDao;
import cn.itcast.jk.dao.ExportProductDao;
import cn.itcast.jk.dao.ExtEproductDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.Export;
import cn.itcast.jk.domain.ExportProduct;
import cn.itcast.jk.domain.ExtEproduct;
import cn.itcast.jk.pagination.Page;
import cn.itcast.jk.service.ExportService;
import cn.itcast.jk.vo.ContractProductVO;
import cn.itcast.jk.vo.ContractVO;
import cn.itcast.jk.vo.ExtCproductVO;
import cn.itcast.util.UtilFuns;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月17日
 */
@Service
@WebService
public class ExportServiceImpl implements ExportService {
	@Resource
	ExportDao exportDao;
	@Resource
	ExportProductDao exportProductDao;
	@Resource
	ExtEproductDao extEproductDao;
	@Resource
	ContractDao contractDao;
	
	//利用set方法，在cxf中注入dao，这样cxf的WebService才可以查询我们系统的数据
	@WebMethod(exclude=true)
	public void setExportDao(ExportDao exportDao) {
		this.exportDao = exportDao;
	}

	@WebMethod(exclude=true)
	public List<Export> findPage(Page page) {
		return exportDao.findPage(page);
	}

	@WebMethod(exclude=true)
	public List<Export> find(Map paraMap) {
		return exportDao.find(paraMap);
	}

	public Export get(String id) {
		return exportDao.get(id);
	}

	@WebMethod(exclude=true)
	public void insert(String[] contractIds) {
		/*
		 * 步骤：
		 * 1、根据合同id获得合同对象，获取合同号
		 * 2、将合同下的货物信息搬家到报运下的货物表中
		 * 3、将合同下的附件信息搬家到报运下的附件表中
		 */
		
		//拼接合同号，报运号
		String contractNos = "";
		for(int i=0;i<contractIds.length;i++){
			ContractVO contract = contractDao.view(contractIds[i]);
			contractNos += contract.getContractNo() + " ";				//以空格作为分隔符
		}
		contractNos = UtilFuns.delLastChar(contractNos);				//工具类，删除最后一个字符
		
		Export export = new Export();
		export.setId(UUID.randomUUID().toString());
		
		//x,y
		export.setContractIds(UtilFuns.joinStr(contractIds, ","));		//工具类，拼串
		export.setCustomerContract(contractNos);
		
		export.setState(0);												//0草稿
		
		exportDao.insert(export);
		
		//处理货物信息
		for(int i=0;i<contractIds.length;i++){
			ContractVO contract = contractDao.view(contractIds[i]);
			
			for(ContractProductVO cp : contract.getContractProducts()){
			
				ExportProduct ep = new ExportProduct();
				ep.setId(UUID.randomUUID().toString());
				ep.setExportId(export.getId());					//绑定外键
				
				//数据搬家，将合同下的对应的货物信息写入到报运下的货物信息中
				ep.setFactoryId(cp.getFactory().getId());
				ep.setFactoryName(cp.getFactory().getFactoryName());
				ep.setProductNo(cp.getProductNo());
				ep.setPackingUnit(cp.getPackingUnit());
				ep.setCnumber(cp.getCnumber());
				ep.setBoxNum(cp.getBoxNum());
				ep.setPrice(cp.getPrice());
				
				exportProductDao.insert(ep);
				
				//处理附件信息
				for(ExtCproductVO extcp : cp.getExtCproducts()){
					ExtEproduct extep = new ExtEproduct();
					
					//copyProperties spring
					BeanUtils.copyProperties(extcp, extep);		//spring工具类，数据的拷贝
					
					extep.setId(UUID.randomUUID().toString());
					extep.setExportProductId(ep.getId());		//绑定外键
					
					extep.setFactoryId(extcp.getFactory().getId());
					extep.setFactoryName(extcp.getFactory().getFactoryName());
					
					extEproductDao.insert(extep);
				}
			}
		}
	}

	@WebMethod(exclude=true)
	public void update(Export export,
			String[] mr_id,
			Integer[] mr_orderNo,
			Integer[] mr_cnumber,
			Double[] mr_grossWeight,
			Double[] mr_netWeight,
			Double[] mr_sizeLength,
			Double[] mr_sizeWidth,
			Double[] mr_sizeHeight,
			Double[] mr_exPrice,
			Double[] mr_tax,
			Integer[] mr_changed
		){
		exportDao.update(export);
		//批量修改货物信息
		
		for(int i=0;i<mr_id.length;i++){
			if(mr_changed[i]!=null && mr_changed[i]==1){			//修改标识，只有用户修改的行才进行更新
				ExportProduct ep = exportProductDao.get(mr_id[i]);
				
				ep.setOrderNo(mr_orderNo[i]);
				ep.setCnumber(mr_cnumber[i]);
				ep.setGrossWeight(mr_grossWeight[i]);
				ep.setNetWeight(mr_netWeight[i]);
				ep.setSizeLength(mr_sizeLength[i]);
				ep.setSizeWidth(mr_sizeWidth[i]);
				ep.setSizeHeight(mr_sizeHeight[i]);
				ep.setExPrice(mr_exPrice[i]);
				ep.setTax(mr_tax[i]);
				
				exportProductDao.update(ep);
			}
		}
	}

	@WebMethod(exclude=true)
	public void deleteById(Serializable id) {
		exportDao.deleteById(id);
	}

	@WebMethod(exclude=true)
	public void delete(Serializable[] ids) {
		exportDao.delete(ids);
	}

	@WebMethod(exclude=true)
	public void submit(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 1);				//1已上报
		map.put("ids", ids);
		
		exportDao.updateState(map);
	}

	@WebMethod(exclude=true)
	public void cancel(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 0);				//0草稿
		map.put("ids", ids);
		
		exportDao.updateState(map);
	}

	@WebMethod(exclude=true)
	public List<Contract> getContractList() {
		Map paraMap = new HashMap();
		paraMap.put("state", 1);			//1已上报
		
		return contractDao.find(paraMap);
	}
	
	//拼接JS串
	//function addTRRecord(objId, id, productNo, cnumber, grossWeight, netWeight, sizeLength, sizeWidth, sizeHeight, exPrice, tax)
	@WebMethod(exclude=true)
	public String getMrecordData(String exportId){
		Map paraMap = new HashMap();
		paraMap.put("exportId", exportId);
		
		List<ExportProduct> oList = exportProductDao.find(paraMap );
		
		StringBuffer sBuf = new StringBuffer();
		for(ExportProduct ep : oList){
			sBuf.append("addTRRecord(\"mRecordTable\", \"").append(ep.getId()).append("\", \"").append(ep.getProductNo()).append("\", \"").append(ep.getCnumber()).append("\", \"").append(UtilFuns.convertNull(ep.getGrossWeight())).append("\", \"").append(UtilFuns.convertNull(ep.getNetWeight())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeLength())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeWidth())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeHeight())).append("\", \"").append(UtilFuns.convertNull(ep.getExPrice())).append("\", \"").append(UtilFuns.convertNull(ep.getTax())).append("\");");
		}
		
		return sBuf.toString();
	}
			

}
