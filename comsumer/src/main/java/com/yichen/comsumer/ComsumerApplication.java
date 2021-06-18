package com.yichen.comsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class ComsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComsumerApplication.class, args);
	}

}
