package com.sadelax.inicio;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sadelax.config.Config;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		new AnnotationConfigApplicationContext(Config.class);
		
	}
}