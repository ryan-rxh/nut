package com.nut.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nut.dao.IUserDao;
import com.nut.domain.UserInfo;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void addUser(UserInfo user) {
		hibernateTemplate.save(user);
	}

	public boolean validateUser(UserInfo user) {
		UserInfo userinfo = (UserInfo) hibernateTemplate.get(UserInfo.class.getName(), user.getUserId());
		if(userinfo == null || !userinfo.getPassword().equals(user.getPassword())){
			return false;
		}
		else{
			return true;
		}
	}

	public UserInfo findUser(String userId) {
		UserInfo userInfo = hibernateTemplate.get(UserInfo.class, userId);
		return userInfo;
	}

}
