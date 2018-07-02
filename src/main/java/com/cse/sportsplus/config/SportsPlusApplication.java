package com.cse.sportsplus.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.cse") // search for all the beans in the packages
@EnableJpaRepositories(basePackages = "com.cse") // enables the jpa repo for the base package
@EntityScan("com.cse")  // looks for all the objects that have @Entity above it

public class SportsPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsPlusApplication.class, args);
	}
}
