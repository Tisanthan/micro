package com.example.tisuUserApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TisuUserAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TisuUserAppApplication.class, args);
	}

}
