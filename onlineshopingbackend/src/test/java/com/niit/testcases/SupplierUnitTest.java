package com.niit.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDao;
import com.niit.model.Supplier;

public class SupplierUnitTest 
{

	@Autowired
	static SupplierDao supplierDao;
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.niit");
	    context.refresh();
	    
	    supplierDao=(SupplierDao) context.getBean("supplierDao");
	}
	
	@Ignore
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("James");
		supplier.setSupplierAddress("10-23/A Ameerpet Hyd");
		
		assertTrue("Problem in adding the supplier",supplierDao.addSupplier(supplier));
	}


	
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDao.getSupplierById(1);
		
		assertTrue("Problem in deleting supplier",supplierDao.deleteSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDao.getSupplierById(2);
		supplier.setSupplierAddress("Western Wear");
		
		assertTrue("Problem in updating supplier",supplierDao.updateSupplier(supplier));
	}
	@Ignore
	@Test
	public void listAllSupplierTestCase() {
	int actualSize = supplierDao.listSuppliers().size();
	assertEquals(0, actualSize);
	}

}
