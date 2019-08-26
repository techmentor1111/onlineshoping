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
    
	public boolean addUser(UserInfo user) 
    {
    	try
        {
        sessionFactory.getCurrentSession().save(user);
        return true;
        }
        catch(Exception e)
        {
        return false;
	}
}

	public boolean updateAddress(UserInfo user) {
		try
        {
        sessionFactory.getCurrentSession().update(user);
        return true;
        }
        catch(Exception e)
        {
        return false;
        }
}

	public UserInfo getUser(String username) {
		{
		    Session session=sessionFactory.openSession();
	        UserInfo user=session.get(UserInfo.class,username); 
	        session.close();
			return user;
	}
}

}
