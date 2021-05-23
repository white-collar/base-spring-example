package com.example.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo3Application {

	@Autowired
	ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}

}
