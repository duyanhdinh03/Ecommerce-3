package com.example.Ecomv3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example.Ecomv3"})
@EnableJpaRepositories(basePackages = {"com.example.Ecomv3.Repositories"})
@EntityScan(basePackages = {"com.example.Ecomv3.Model"})
public class Ecomv3Application {
	public static void main(String[] args) {
		SpringApplication.run(Ecomv3Application.class, args);
	}
}
