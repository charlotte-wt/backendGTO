package com.example.gto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.gto")
public class GtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtoApplication.class, args);
	}

	

}

