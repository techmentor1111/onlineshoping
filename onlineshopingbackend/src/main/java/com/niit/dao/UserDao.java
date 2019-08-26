package com.niit.dao;

import java.util.List;

import com.niit.model.UserInfo;

public interface UserDao {

	   public boolean addUser(UserInfo userInfo);
	    public boolean updateAddress(UserInfo user);
		public UserInfo getUser(String username);
}
