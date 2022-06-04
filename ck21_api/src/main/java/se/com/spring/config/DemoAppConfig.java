package se.com.spring.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("se.com.spring")
@PropertySource({"classpath:db.properties"})
public class DemoAppConfig {
	@Autowired
	private Environment environment;
	@Bean
	public DataSource myDataSource() {
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(environment.getProperty("driver"));
		} catch (PropertyVetoException e) {
			
			throw new RuntimeException(e);
		}
		dataSource.setJdbcUrl(environment.getProperty("url"));
		dataSource.setUser(environment.getProperty("user"));
		dataSource.setPassword(environment.getProperty("pass"));
		return dataSource;
	}
	private Properties getProperties() {
		Properties properties=new Properties();
		properties.setProperty("dialect", environment.getProperty("dialect"));
		properties.setProperty("showsql", environment.getProperty("showsql"));
		return properties;
	}
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean() {
		LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();
		factoryBean.setDataSource(myDataSource());
		factoryBean.setPackagesToScan(environment.getProperty("scan"));
		factoryBean.setHibernateProperties(getProperties());
		return factoryBean;
	}
	@Bean
	@Autowired
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager manager=new HibernateTransactionManager();
		manager.setSessionFactory(sessionFactory);
		return manager;
	}
	
}
