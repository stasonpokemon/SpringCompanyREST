package com.trebnikau.spring.company.rest.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.trebnikau.spring.company.rest")
@EnableWebMvc
@EnableTransactionManagement
public class SpringConfiguration {

    // Бин отвечающий за подключение к базе данных
    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/my_company?useSSL=false&serverTimeZone=UTC");
            dataSource.setUser("spring");
            dataSource.setPassword("admin");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    // Бин отвечающий за конфигурацию SessionFactory
    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.trebnikau.spring.company.rest.entity");
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty("hibernate.show_sql","true");
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    // Бин отвечающий за конфигурацию HibernateTransactionManager
    @Bean
    public HibernateTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
        return hibernateTransactionManager;
    }
}
