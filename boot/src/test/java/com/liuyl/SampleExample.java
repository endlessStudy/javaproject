package com.liuyl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@EnableAutoConfiguration
public class SampleExample {
	@RequestMapping("/")
	@ResponseBody
	public String getName(){
		return "liuyl";
	}
	public static void main(String[] args) {
		SpringApplication.run(SampleExample.class, args);
	}
}
