package com.niit.furniturebackend;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit")
public class DBConfig {
	@Bean
	DataSource mydatasource()
		
	{
		BasicDataSource basicDataSource=new BasicDataSource();
		basicDataSource.setDriverClassName("org.h2.Driver");
		basicDataSource.setUrl("jdbc:h2:tcp://localhost/~/project");
		basicDataSource.setUsername("sa");
		basicDataSource.setPassword("sa");
		return basicDataSource;
	}
	@Bean
	Properties properties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate-dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		return properties;
	}
	@Autowired
	@Bean("sessionfactory")
	LocalSessionFactoryBean localSessionFactoryBean()
	{
		LocalSessionFactoryBean lSFBean=new LocalSessionFactoryBean();
		lSFBean.setDataSource(mydatasource());
		lSFBean.setHibernateProperties(properties());
		lSFBean.setPackagesToScan("com.niit.furniturebackend");
		return lSFBean;
	}
	@Autowired
	@Bean
	HibernateTransactionManager htm(SessionFactory sessionfactory)
	{
		HibernateTransactionManager ht=new HibernateTransactionManager();
		ht.setSessionFactory(sessionfactory);
		return ht;
		
		
	}
}
