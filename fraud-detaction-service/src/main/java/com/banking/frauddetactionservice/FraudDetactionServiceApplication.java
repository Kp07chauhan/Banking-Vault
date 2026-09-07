package com.banking.frauddetactionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FraudDetactionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FraudDetactionServiceApplication.class, args);
	}

}
