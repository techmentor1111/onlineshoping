package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.UserInfo;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit")
public class Config 
{
	
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
	
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
	
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	dataSource.setUsername("sa");
	dataSource.setPassword("");
	
	System.out.println("----DataSource object is created---");
	return dataSource;
	}
	
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp=new Properties();
		
		hibernateProp.put("hibernate.hbm2ddl.auto","update");
		hibernateProp.put("hibernate.show_sql","true");
		hibernateProp.put("hibernate.sql_format","true");
		
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());
    
		factory.addProperties(hibernateProp);
        
        factory.addAnnotatedClass(Category.class);
        factory.addAnnotatedClass(Supplier.class);
        factory.addAnnotatedClass(Product.class);
        factory.addAnnotatedClass(UserInfo.class);
        
        
        System.out.println("---SessionFactory object created----");
        
        return factory.buildSessionFactory();
        		
	}
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
	System.out.println("----Transaction Object created----");
	return new HibernateTransactionManager(sessionFactory);
	}

	
}
