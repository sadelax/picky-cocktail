package com.sadelax.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan({"com.sadelax.inicio", "com.sadelax.modelo", "com.sadelax.persistencia", "com.sadelax.vista"})
@PropertySource("classpath:pickycocktail.properties")
@Import({JPAConfig.class})
public class Config {

	@Autowired
	Environment prop;
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(prop.getProperty("bbdd.driver"));
		bds.setUrl(prop.getProperty("bbdd.url"));
		bds.setUsername(prop.getProperty("bbdd.user"));
		bds.setPassword(prop.getProperty("bbdd.pwd"));
		return bds;
	}
}
