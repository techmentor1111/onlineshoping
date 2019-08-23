package com.niit.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;

public class CategoryUnitTest {

	@Autowired
	static CategoryDao categoryDao;
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.niit");
	    context.refresh();
	    
	    categoryDao=(CategoryDao) context.getBean("categoryDao");
	}
	
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("Women Dresses");
		category.setCategoryDesc("Ethnic wear for WoMen");
		
		assertTrue("Problem in adding the category",categoryDao.addCategory(category));
	}


	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDao.getCategoryById(1);
		
		assertTrue("Problem in deleting category",categoryDao.deleteCategory(category));
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDao.getCategoryById(2);
		category.setCategoryDesc("Western Wear");
		
		assertTrue("Problem in updating category",categoryDao.updateCategory(category));
	}
	@Ignore
	@Test
	public void listAllCategoryTestCase() {
	int actualSize = categoryDao.listCategories().size();
	assertEquals(3, actualSize);
	}

}
