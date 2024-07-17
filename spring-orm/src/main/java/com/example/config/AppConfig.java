package com.example.config;

import com.example.models.User;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
// import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.example" })
@EnableTransactionManagement
public class AppConfig {

  @Bean
  public DriverManagerDataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3307/spring");
    dataSource.setUsername("root");
    dataSource.setPassword("root");
    return dataSource;
  }

  private Properties hibernateProperties() {
    Properties properties = new Properties();
    // properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    properties.put("hibernate.hbm2ddl.auto", "update");
    properties.put("hibernate.show_sql", "true");
    properties.put("hibernate.format_sql", "true");
    return properties;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    sessionFactoryBean.setDataSource(dataSource());
    sessionFactoryBean.setAnnotatedClasses(User.class);
    sessionFactoryBean.setHibernateProperties(hibernateProperties());

    return sessionFactoryBean;
  }

  @Bean
  public PlatformTransactionManager transactionManager(
    SessionFactory sessionFactory
  ) {
    return new HibernateTransactionManager(sessionFactory);
  }
  //   @Bean
  //   public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
  //     return new HibernateTemplate(sessionFactory);
  //   }
}
