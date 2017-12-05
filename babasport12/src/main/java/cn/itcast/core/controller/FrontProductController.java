package cn.itcast.core.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.common.page.Pagination;
import cn.itcast.common.web.session.SessionProvider;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.bean.product.Color;
import cn.itcast.core.bean.product.Feature;
import cn.itcast.core.bean.product.Product;
import cn.itcast.core.bean.product.Sku;
import cn.itcast.core.bean.product.Type;
import cn.itcast.core.query.product.BrandQuery;
import cn.itcast.core.query.product.FeatureQuery;
import cn.itcast.core.query.product.ProductQuery;
import cn.itcast.core.query.product.SkuQuery;
import cn.itcast.core.query.product.TypeQuery;
import cn.itcast.core.service.product.BrandService;
import cn.itcast.core.service.product.ColorService;
import cn.itcast.core.service.product.FeatureService;
import cn.itcast.core.service.product.ProductService;
import cn.itcast.core.service.product.SkuService;
import cn.itcast.core.service.product.TypeService;

/**
 * 前台商品列表
 * 测试
 * 商品详情页面
 * 
 * @author lx
 *
 */
@Controller
public class FrontProductController {
	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private FeatureService featureService;
	
	
	@Autowired
	private SessionProvider sessionProvider;
	
	//商品列表页面
	@RequestMapping(value = "/product/display/list.shtml")
	public String list(Integer pageNo,Integer brandId,String brandName,Integer typeId,String typeName,ModelMap model){

		//加载商品属性
		FeatureQuery featureQuery = new FeatureQuery();
		
		List<Feature> features = featureService.getFeatureList(featureQuery);
		//显示在页面
		model.addAttribute("features", features);
		
		
		//分页参数
		StringBuilder params = new StringBuilder();
		//设置页号
		ProductQuery productQuery = new ProductQuery();
		productQuery.setPageNo(Pagination.cpn(pageNo));
		//设置每页数
		productQuery.setPageSize(Product.FRONT_PAGE_SIZE);
		//设置Id倒排
		productQuery.orderbyId(false);
		//条件 TODO
		//隐藏已选条件
		boolean flag = false;
		//条件Map窗口
		Map<String,String> query = new LinkedHashMap<String,String>();
		
		
		//品牌ID
		if(null != brandId){
			productQuery.setBrandId(brandId);
			flag = true;
			//显示在页面
			model.addAttribute("brandId", brandId);
			model.addAttribute("brandName", brandName);
			
			query.put("品牌", brandName);
			
			params.append("&").append("brandId=").append(brandId).append("&brandName=").append(brandName);
		}else{
			//加载商品品牌
			//品牌条件对象
			BrandQuery brandQuery = new BrandQuery();
			//设置指定字段
			brandQuery.setFields("id,name");
			//设置可见
			brandQuery.setIsDisplay(1);
			//加载品牌
			List<Brand> brands = brandService.getBrandList(brandQuery);
			//显示在页面
			model.addAttribute("brands", brands);
		}
		//类型ID
		if(null != typeId){
			productQuery.setTypeId(typeId);
			flag = true;
			query.put("类型", typeName);
			//显示在页面
			model.addAttribute("typeId", typeId);
			model.addAttribute("typeName", typeName);
			params.append("&").append("typeId=").append(typeId).append("&typeName=").append(typeName);
		}else{
			//加载商品类型
			TypeQuery typeQuery = new TypeQuery();
			//指定查询哪些字段
			typeQuery.setFields("id,name");
			typeQuery.setIsDisplay(1);
			typeQuery.setParentId(0);
			List<Type> types = typeService.getTypeList(typeQuery);
			//显示在页面
			model.addAttribute("types", types);
		}
		model.addAttribute("flag", flag);
		//条件
		model.addAttribute("query", query);
		
		
		
		
		//加载带有分页的商品
		Pagination pagination = productService.getProductListWithPage(productQuery);
		
		//分页页面展示    //String params = "brandId=1&name=2014瑜伽服套装新款&pageNo=1";
		String url = "/product/display/list.shtml";
		pagination.pageView(url, params.toString());
		
		model.addAttribute("pagination", pagination);
		
		
		return "product/product";
	}
	//跳转商品详情页
	@RequestMapping(value = "/product/detail.shtml")
	public String detail(Integer id,ModelMap model){
		//商品加载
		Product product = productService.getProductByKey(id);
		
		model.addAttribute("product", product);
		
		//skus
		List<Sku> skus = skuService.getStock(id);
		model.addAttribute("skus", skus);
		//去重复
		List<Color>  colors = new ArrayList<Color>();
		//遍历SKu
		for(Sku sku : skus){
			//判断集合中是否已经有此颜色对象了
			if(!colors.contains(sku.getColor())){
				colors.add(sku.getColor());
			}
		}
		model.addAttribute("colors", colors);
		
		return "product/productDetail";
	}
	@Autowired
	private SkuService skuService;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//每一个Springmvc
	@RequestMapping(value = "/test/springmvc.do")
	public String test(String name,Date birthday){
		
		
		System.out.println();
		return "";
	}

/*	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		//转换日期格式
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
	}
	*/
	

}
