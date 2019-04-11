package com.app.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.app")
@PropertySource(value = { "classpath:db.properties" })
@EnableTransactionManagement
public class SpringConfiguration extends WebMvcConfigurerAdapter {
	@Autowired
	Environment environment;

	// read properties file
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resource/**").addResourceLocations("/resources/");
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(environment.getProperty("mysql.driver"));
		dataSource.setUrl(environment.getProperty("mysql.url"));
		dataSource.setUsername(environment.getProperty("mysql.username"));
		dataSource.setPassword(environment.getProperty("mysql.password"));

		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	
	
	
//	@Bean()
//	public LocalSessionFactoryBean sessionFactoryBean() {
//		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
//		bean.setDataSource(dataSource());
//		bean.setPackagesToScan("com.app.model.entitymodel");
//
//		Properties hibernateProperties = new Properties();
//
//		hibernateProperties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
//		hibernateProperties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
//		hibernateProperties.put("hibernate.connection.characterEncoding",
//				environment.getProperty("hibernate.connection.characterEncoding"));
//		hibernateProperties.put("hibernate.connection.CharSet",
//				environment.getProperty("hibernate.connection.CharSet"));
//
//		bean.setHibernateProperties(hibernateProperties);
//
//		return bean;
//	}
//
//	@Bean(name = "transactionManager")
//	@Autowired
//	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
//		hibernateTransactionManager.setSessionFactory(sessionFactory);
//
//		return hibernateTransactionManager;
//	}

}
