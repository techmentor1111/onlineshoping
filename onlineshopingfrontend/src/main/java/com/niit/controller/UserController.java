package com.niit.controller;




import java.util.Collection;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.ProductDao;
import com.niit.dao.UserDao;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.UserInfo;

@Controller
public class UserController 
{
    @Autowired
    ProductDao productDao;
    
    @Autowired
    UserDao userDao;
    
    @RequestMapping(value="/userhome")
	public String showUserHome(Model m,HttpSession session)
	{
        m.addAttribute("pageinfo","Product Gallery");
		
		List<Product> listProducts=productDao.listProducts();
		m.addAttribute("productList", listProducts);
        return "UserHome";
	}
    
    
    
    @RequestMapping(value="/addUser",method=RequestMethod.POST)
    public String addUser(Model m, @RequestParam("userName")String username,@RequestParam("customerName")String customerName,@RequestParam("customerAddr")String customerAddr, @RequestParam("password")String password)
    {
    	    	
    	UserInfo user=new UserInfo();
    	user.setCustomerAddr(customerAddr);
    	user.setCustomerName(customerName);
    	user.setEnabled(true);
    	user.setRole("ROLE_USER");
    	user.setPassword(password);
    	user.setUsername(username);
    	
    	userDao.addUser(user);
				
		return "Login";
    	
	}
    
    
	
	
	
	
}
