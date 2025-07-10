package com.lohithpuvvala.restful_bookstore_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulBookstoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulBookstoreApiApplication.class, args);
		System.out.println("Open Swagger: http://localhost:8080/swagger-ui/index.html#/");
	}
}
