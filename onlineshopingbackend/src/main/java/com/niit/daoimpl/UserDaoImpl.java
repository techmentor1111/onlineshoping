package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDao;
import com.niit.model.Category;
import com.niit.model.UserInfo;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao 
{
	@Autowired
    SessionFactory sessionFactory;
	
	public boolean addUser(UserInfo userInfo) {

		  try
	        {
	        sessionFactory.getCurrentSession().save(userInfo);
	        return true;
	        }
	        catch(Exception e)
	        {
	        return false;
		}
		  
	}

	public boolean deleteUser(UserInfo userInfo) {

		try
        {
        sessionFactory.getCurrentSession().delete(userInfo);
        return true;
        }
        catch(Exception e)
        {
        return false;
        }

	}

	public boolean updateUser(UserInfo userInfo) {

		try
        {
        sessionFactory.getCurrentSession().update(userInfo);
        return true;
        }
        catch(Exception e)
        {
        return false;
	}

	}

	public UserInfo getUserById(int userID) 
	{
		 Session session=sessionFactory.openSession();
	        UserInfo userInfo=session.get(UserInfo.class,userID);        
			return userInfo;
	}


}
