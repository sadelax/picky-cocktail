package com.pickycocktail.usuarios.infraestructura.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.pickycocktail.usuarios.infraestructura.persistence")
@EnableTransactionManagement
public class JPAConfig {
	
	@Bean("entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean emf(DataSource ds) {
		
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		
		emf.setDataSource(ds);
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setPackagesToScan("com.pickycocktail.usuarios.dominio.model");
		
		Map<String, Object> prop = new HashMap<>();
		prop.put("hibernate.show_sql", true);
		prop.put("hibernate.dialect", "org.sqlite.hibernate.dialect.SQLiteDialect");
		prop.put("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
		
		emf.setJpaPropertyMap(prop);
		
		return emf;
	}
	
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager txM = new JpaTransactionManager();
		txM.setEntityManagerFactory(emf);
		return txM;
	}

}
