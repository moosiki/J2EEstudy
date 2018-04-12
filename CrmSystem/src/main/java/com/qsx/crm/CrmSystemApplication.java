package com.qsx.crm;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrmSystemApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(CrmSystemApplication.class);
	
	@PostConstruct
	public void initApplication() throws IOException{
		logger.info("Running with spring profile(s) :{}");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CrmSystemApplication.class, args);
	}
	
	@Bean  
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {  
        return hemf.getSessionFactory();  
    } 
}
