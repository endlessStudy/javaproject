package com.liuyl.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//@EnableAutoConfiguration
public class TestController {
	@RequestMapping("/")
	@ResponseBody
	public String getName(){
		return "liuyl";
	}
}
