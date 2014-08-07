package com.nut.service;

import com.nut.domain.UserInfo;

public interface IUserService {
	public void addUser(UserInfo user);
	public UserInfo findUser(String userId);
	public boolean validateUser(UserInfo user);
}
