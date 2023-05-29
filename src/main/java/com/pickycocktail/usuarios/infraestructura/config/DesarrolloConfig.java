package com.pickycocktail.usuarios.infraestructura.config;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
@Profile("desarrollo")
public class DesarrolloConfig {

	@Autowired
	Environment prop;
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(prop.getProperty("des.bbdd.driver"));
		bds.setUrl(prop.getProperty("des.bbdd.url"));
		bds.setUsername(prop.getProperty("des.bbdd.user"));
		bds.setPassword(prop.getProperty("des.bbdd.pwd"));
		return bds;
	}
}
