package cn.itcast.core.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.common.web.ResponseUtils;
import cn.itcast.core.bean.product.Sku;
import cn.itcast.core.query.product.SkuQuery;
import cn.itcast.core.service.product.SkuService;

/**
 * 库存管理
 * 修改库存
 * @author lx
 *
 */
@Controller
public class SkuController {

	@Autowired
	private SkuService skuService;
	//跳转到库存管理页面
	@RequestMapping(value = "/sku/list.do")
	public String list(Integer productId,String pno ,ModelMap model){
		
		//商品编号回显
		model.addAttribute("pno", pno);
		
		//最小销售单元  通过商品ID
		SkuQuery skuQuery = new SkuQuery();
		skuQuery.setProductId(productId);
		List<Sku> skus = skuService.getSkuList(skuQuery);
		
		//商品编号回显
		model.addAttribute("skus", skus);
		
		return "sku/list";
	}
	//保存/修改
	@RequestMapping(value = "/sku/add.do")
	public void add(Sku sku ,ModelMap model,HttpServletResponse response){
		//修改
		skuService.updateSkuByKey(sku);
		//
		JSONObject jo = new JSONObject();
		jo.put("message", "保存成功!");
		
		ResponseUtils.renderJson(response, jo.toString());
		
	}
}
