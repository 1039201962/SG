package com.sg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	
	@RequestMapping("/page/{moduleName}")
	public String module(@PathVariable String moduleName) {
		
		return moduleName;
	}
	
	@RequestMapping("/hello")
	@ResponseBody  
	public String hello() {
		
		return "abcdefg";
	}
}
