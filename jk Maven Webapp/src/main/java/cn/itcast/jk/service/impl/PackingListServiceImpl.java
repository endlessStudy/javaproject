package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.ExportDao;
import cn.itcast.jk.dao.PackingListDao;
import cn.itcast.jk.domain.Export;
import cn.itcast.jk.domain.PackingList;
import cn.itcast.jk.pagination.Page;
import cn.itcast.jk.service.PackingListService;
import cn.itcast.util.UtilFuns;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月11日
 */
@Service
public class PackingListServiceImpl implements PackingListService {
	@Resource
	PackingListDao packingListDao;
	@Resource
	ExportDao exportDao;

	public List<PackingList> findPage(Page page) {
		return packingListDao.findPage(page);
	}

	public List<PackingList> find(Map paraMap) {
		return packingListDao.find(paraMap);
	}

	public PackingList get(Serializable id) {
		return packingListDao.get(id);
	}

	public void insert(PackingList packingList) {
		this.spellString(packingList);
		
		packingList.setId(UUID.randomUUID().toString());
		packingList.setState(0);					//0草稿1已上报
		packingListDao.insert(packingList);
	}

	public void update(PackingList packingList) {
		this.spellString(packingList);
		
		packingListDao.update(packingList);
	}

	public void deleteById(Serializable id) {
		Serializable[] ids = {id};
		packingListDao.deleteById(id);
	}

	public void delete(Serializable[] ids) {
		packingListDao.delete(ids);
	}

	public void submit(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 1);				//1已上报
		map.put("ids", ids);
		
		packingListDao.updateState(map);
	}

	public void cancel(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 0);				//0草稿
		map.put("ids", ids);
		
		packingListDao.updateState(map);
	}

	//拼接HTML片段
	public String getDivDataCreate(String[] exportIds){
		StringBuffer sBuf = new StringBuffer();
		for(int i=0;i<exportIds.length;i++){
			Export export = exportDao.get(exportIds[i]);
			sBuf.append("<input type=\"checkbox\" name=\"exportIds\" checked value=\"").append(exportIds[i]).append("|").append(export.getCustomerContract()).append("\" class=\"input\"/>");
			sBuf.append(export.getCustomerContract()).append("&nbsp;&nbsp;");
		}
		
		return sBuf.toString();
	}
	
	//拼接HTML片段
	public String getDivDataUpdate(String[] exportIds, String[] exportNos){
		StringBuffer sBuf = new StringBuffer();
		for(int i=0;i<exportIds.length;i++){
			sBuf.append("<input type=\"checkbox\" name=\"exportIds\" checked value=\"").append(exportIds[i]).append("|").append(exportNos[i]).append("\" class=\"input\"/>");
			sBuf.append(exportNos[i]).append("&nbsp;&nbsp;");
		}
		
		return sBuf.toString();
	}
	
	//拼接HMTL片段
	public String getDivDataView(String[] exportNos){
		StringBuffer sBuf = new StringBuffer();
		for(int i=0;i<exportNos.length;i++){
			sBuf.append(exportNos[i]).append("&nbsp;&nbsp;");
		}
		
		return sBuf.toString();
	}
	
	
	//拆串，拼串
	private PackingList spellString(PackingList packingList){
		String _exportIds = "";
		String _exportNos = "";
		
		String[] _s = packingList.getExportIds().split(",");		//id|no
		for(int i=0;i<_s.length;i++){	
			String[] _tmp = _s[i].split("\\|");						//正则表达式，转义
			_exportIds +=  _tmp[0] + "|";
			_exportNos +=  _tmp[1] + "|";
		}
		_exportIds = UtilFuns.delLastChar(_exportIds);
		_exportNos = UtilFuns.delLastChar(_exportNos);
		
		packingList.setExportIds(_exportIds);
		packingList.setExportNos(_exportNos);
		
		return packingList;
	}

}
