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
	public PageObject findAllUser(Integer page,Integer limit){
		PageObject findAllUser = userService.findAllUser(page,limit);	
		  return findAllUser;
	}
}
