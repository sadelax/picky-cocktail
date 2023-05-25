package com.pickycocktail.inicio;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pickycocktail.config.Config;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		new AnnotationConfigApplicationContext(Config.class);
		
	}
}