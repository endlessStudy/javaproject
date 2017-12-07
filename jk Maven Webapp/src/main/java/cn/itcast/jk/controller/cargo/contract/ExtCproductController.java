package cn.itcast.jk.controller.cargo.contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.domain.SysCode;
import cn.itcast.jk.service.ExtCproductService;
import cn.itcast.jk.service.FactoryService;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月13日
 */
@Controller
public class ExtCproductController extends BaseController{
	@Resource
	ExtCproductService extCproductService;
	@Resource
	FactoryService factoryService;
	
	@RequestMapping("/cargo/extcproduct/tocreate.action")
	public String tocreate(String contractProductId, Model model){
		model.addAttribute("contractProductId", contractProductId);			//传递主表的ID
		
		//某个货物下的附件信息
		Map paraMap = new HashMap();
		paraMap.put("contractProductId", contractProductId);
		List<ExtCproduct> dataList = extCproductService.find(paraMap);
		model.addAttribute("dataList", dataList);
		
		//准备生产厂家的下拉列表
		List<Factory> factoryList = factoryService.getFactoryList();
		model.addAttribute("factoryList", factoryList);
		
		//准备分类下拉列表
		List<SysCode> ctypeList = extCproductService.getCtypeList();
		model.addAttribute("ctypeList", ctypeList);
		
		return "/cargo/contract/jExtCproductCreate.jsp";
	}
	
	@RequestMapping("/cargo/extcproduct/insert.action")
	public String insert(ExtCproduct extCproduct, Model model){
		extCproductService.insert(extCproduct);
		model.addAttribute("contractProductId", extCproduct.getContractProductId());		//传递主表ID
		
		return "redirect:/cargo/extcproduct/tocreate.action";
	}
	
	@RequestMapping("/cargo/extcproduct/toupdate.action")
	public String toupdate(String id, Model model){
		ExtCproduct obj = extCproductService.get(id);
		model.addAttribute("obj", obj);
		
		//准备生产厂家的下拉列表
		List<Factory> factoryList = factoryService.getFactoryList();
		model.addAttribute("factoryList", factoryList);
		
		//准备分类下拉列表
		List<SysCode> ctypeList = extCproductService.getCtypeList();
		model.addAttribute("ctypeList", ctypeList);
		
		return "/cargo/contract/jExtCproductUpdate.jsp";
	}
	
	@RequestMapping("/cargo/extcproduct/update.action")
	public String update(ExtCproduct extCproduct, Model model){
		extCproductService.update(extCproduct);
		model.addAttribute("contractProductId", extCproduct.getContractProductId());		//传递主表ID
		
		return "redirect:/cargo/extcproduct/tocreate.action";
	}
	
	@RequestMapping("/cargo/extcproduct/deleteById.action")
	public String deleteById(String id, String contractProductId, Model model){
		extCproductService.deleteById(id);
		model.addAttribute("contractProductId", contractProductId);		//传递主表ID
		
		return "redirect:/cargo/extcproduct/tocreate.action";
	}
}
