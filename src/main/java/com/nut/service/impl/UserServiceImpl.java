package com.nut.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nut.dao.IUserDao;
import com.nut.domain.UserInfo;
import com.nut.service.IUserService;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	public void addUser(UserInfo user) {
		userDao.addUser(user);
	}

	public UserInfo findUser(String userId) {
		return userDao.findUser(userId);
	}

	public boolean validateUser(UserInfo user) {
		return userDao.validateUser(user);
	}

	public boolean validateUserId(String userId) {
		return userDao.validateUserId(userId);
	}

}
