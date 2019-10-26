package com.sg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.service.UserService;
import com.sg.vo.PageObject;

@RestController
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("findAll")
	public PageObject findAllUser(Integer page,Integer limit,String key){
		PageObject findUser=new PageObject();
		if(key==null) {	
		findUser = userService.findAllUser(page,limit);	
		}else {
		findUser = userService.findUser(key);
		}
		return findUser;
	}
}
