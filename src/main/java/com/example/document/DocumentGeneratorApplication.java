package com.example.document;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.example.document")
@SpringBootApplication
public class DocumentGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentGeneratorApplication.class, args);
	}

}
