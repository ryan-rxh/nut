package com.nut.dao;

import com.nut.domain.UserInfo;

public interface IUserDao {
	public void addUser(UserInfo user);
	public UserInfo findUser(String userId);
	public boolean validateUser(UserInfo user);
	public boolean validateUserId(String userId);
}
