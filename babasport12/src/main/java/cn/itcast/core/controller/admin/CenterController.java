package cn.itcast.core.controller.admin;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台管理
 * 测试
 * @author lx
 *
 */
@Controller
@RequestMapping(value = "/control")
public class CenterController {
	
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
	
	//跳转入口页面
	@RequestMapping(value = "/index.do")
	public String index(){
		return "index";
	}
	//跳转头页面
	@RequestMapping(value = "/top.do")
	public String top(){
		return "top";
	}
	//跳转身体页面
	@RequestMapping(value = "/main.do")
	public String main(){
		return "main";
	}
	//跳转左页面
	@RequestMapping(value = "/left.do")
	public String left(){
		return "left";
	}
	//跳转右页面
	@RequestMapping(value = "/right.do")
	public String right(){
		return "right";
	}
	

}
