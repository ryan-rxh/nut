package com.nut.IService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.nut.domain.UserInfo;
import com.nut.service.IUserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-context.xml", "classpath:mvc-context.xml"})
public class IUserServiceTest {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Test
	public void testGetUser() {
		UserInfo user = hibernateTemplate.get(UserInfo.class, "test1");
		Assert.notNull(user);
	}

	@Test
	public void testLoadUser() {
		UserInfo user = hibernateTemplate.load(UserInfo.class, "test1");
		Assert.notNull(user);
	}
}
