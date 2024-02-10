package com.ione.spjpaex.multidb.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "postgresEntityManagerFactory",
        transactionManagerRef = "postgresTransactionManager",
        basePackages = "com.ione.spjpaex.multidb.postgres.repositories")
public class PostgreSQLServerConfig {

    @Bean
    @ConfigurationProperties(prefix = "postgres.db2.datasource")
    public DataSourceProperties postgresDataSourceProperties() {
    	System.out.println("loading postgres ds props......");
        return new DataSourceProperties();
    }
    @Bean
    public DataSource postgresDataSource(@Qualifier("postgresDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "postgresEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(@Qualifier("postgresDataSource") DataSource postgresDataSource, EntityManagerFactoryBuilder builder) {

    
    	
    	LocalContainerEntityManagerFactoryBean em = builder.dataSource(postgresDataSource)
        .packages("com.ione.spjpaex.multidb.postgres.domain")
        .persistenceUnit("postgres")
        .build();
    	
    	em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    	
    	Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                "update");
        properties.put("hibernate.dialect",
        		"org.hibernate.dialect.PostgreSQLDialect");
        em.setJpaPropertyMap(properties);
    	
        return em;

    }

    @Bean
    public PlatformTransactionManager postgresTransactionManager(@Qualifier("postgresEntityManagerFactory")
                                                                              EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}