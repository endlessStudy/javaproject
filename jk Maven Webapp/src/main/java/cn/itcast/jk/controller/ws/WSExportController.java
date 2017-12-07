package cn.itcast.jk.controller.ws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 在系统中调用cxf提供WebService
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月21日
 */
@Controller
public class WSExportController {
	@RequestMapping("/ws/export/toedit.action")
	public String toedit(){
		return "/ws/export/ajaxExport.jsp";
	}
}
