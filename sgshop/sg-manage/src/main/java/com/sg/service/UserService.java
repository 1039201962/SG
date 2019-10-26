package com.sg.service;

import com.sg.vo.PageObject;

public interface UserService {

	PageObject findAllUser(Integer page, Integer limit);

	PageObject findUser(String key);

}
