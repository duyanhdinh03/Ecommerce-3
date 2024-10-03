package com.example.Ecomv3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.demo.model")
@EnableJpaRepositories(basePackages = "com.example.Ecomv3.Repositories")
public class Ecomv3Application {

	public static void main(String[] args) {
		SpringApplication.run(Ecomv3Application.class, args);
	}

}
