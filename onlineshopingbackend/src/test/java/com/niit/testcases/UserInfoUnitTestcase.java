package com.niit.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.model.UserInfo;

public class UserInfoUnitTestcase {

	@Autowired
	static UserDao userDao;
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.niit");
	    context.refresh();
	    
	    userDao=(UserDao) context.getBean("userDao");
	}
	
	@Ignore
	@Test
	public void addUserInfoTest()
	{
		UserInfo user=new UserInfo();

		user.setUsername("rahul");
		user.setPassword("rahul@123");
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		user.setCustomerName("James");
		user.setCustomerAddr("10-23/a Ameerpet Hyd");

		assertTrue("Problem in adding the userInfo",userDao.addUser(user));
	}


	
	


}
