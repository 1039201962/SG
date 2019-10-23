package com.sg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.mapper.UserMapper;
import com.sg.pojo.User;
import com.sg.vo.PageObject;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public PageObject findAllUser(Integer page, Integer limit) {
		Integer users = userMapper.selectCount(null);
		int start = (page - 1) * limit;
		List<User> userList = 
				userMapper.findUser(start,limit);
		return new PageObject(0,"", users , userList);
	}


}
