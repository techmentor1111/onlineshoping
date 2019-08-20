package com.niit.dao;

import java.util.List;

import com.niit.model.UserInfo;

public interface UserDao {

	   public boolean addUser(UserInfo userInfo);
	   public boolean deleteUser(UserInfo userInfo);
	   public boolean updateUser(UserInfo userInfo);
	   public UserInfo getUserById(int userID);
}
