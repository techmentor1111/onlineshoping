package com.niit.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDao;
import com.niit.model.Product;

public class ProductUnitTestcase {
	@Autowired
	static ProductDao productDao;
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.niit");
	    context.refresh();
	    
	    productDao=(ProductDao) context.getBean("productDao");
	}
	
	@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProName("Tshirts");
		product.setProprice(1500);
		product.setProDesc("Maroon and navy blue striped T-shirt");
		product.setStock(20);
		product.setCategoryID(34);
		product.setSupplierId(35);

		assertTrue("Problem in adding the product",productDao.addProduct(product));
	}


	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDao.getProductById(1);
		
		assertTrue("Problem in deleting product",productDao.deleteProduct(product));
	}
	
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDao.getProductById(2);
		//product.setProduct("Western Wear");
		
		assertTrue("Problem in updating product",productDao.updateProduct(product));
	}
	@Ignore
	@Test
	public void listAllProductTestCase() {
	int actualSize = productDao.listProducts().size();
	assertEquals(3, actualSize);
	}


	
}
