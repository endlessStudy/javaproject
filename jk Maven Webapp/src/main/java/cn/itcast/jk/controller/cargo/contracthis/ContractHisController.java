package cn.itcast.jk.controller.cargo.contracthis;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.service.ContractHisService;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月20日
 */
@Controller
public class ContractHisController extends BaseController {
	@Resource
	ContractHisService contractHisService;
	
	//历史列表
	@RequestMapping("/cargo/contracthis/list.action")
	public String list(Model model){
		List<Contract> dataList = contractHisService.find(null);
		model.addAttribute("dataList", dataList);
		
		return "/cargo/contracthis/jContractHisList.jsp";
	}
	
	//归档
	@RequestMapping("/cargo/contracthis/pigeinhole.action")
	public String pigeinhole(String[] id){
		contractHisService.pigeinhole(id);
		
		return "redirect:/cargo/contracthis/list.action";
	}
	
	//取消归档
	@RequestMapping("/cargo/contracthis/pigeouthole.action")
	public String pigeouthole(String[] id){
		contractHisService.pigeouthole(id);
		
		return "redirect:/cargo/contracthis/list.action";
	}
}
