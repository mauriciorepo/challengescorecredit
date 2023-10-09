package com.challenge.creditscore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class CreditScoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditScoreApplication.class, args);
	}

}
