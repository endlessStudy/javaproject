package com.lxy.ehcache.control;

import com.lxy.ehcache.entity.SystemLog;
import com.lxy.ehcache.service.SystemLogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.xml.ws.RequestWrapper;

/**
 * Created by liuyl on 2018/1/12.
 */
@Controller
@RequestMapping("systemLogController")
public class SystemLogController {

    @Resource
    private SystemLogService systemLogService;

    @RequestMapping("testLog")
    public ModelAndView testLog() {
        ModelMap modelMap = new ModelMap();
        SystemLog systemLog = systemLogService.findSystemLog("c30e2398-079a-406b-a2f7-a85fa15ccac7");
        modelMap.addAttribute("data", systemLog);
        return new ModelAndView("index", modelMap);
    }

    @RequestMapping("insert")
    @ResponseBody
    public boolean Insert(SystemLog record) {
        systemLogService.insert(record);
        return true;
    }

    @RequestMapping("test1")
    public ModelAndView test1() {
        ModelMap modelMap = new ModelMap();
        int num = systemLogService.count();
        modelMap.addAttribute("num", num);
        return new ModelAndView("pageEhcache", modelMap);
    }
}
