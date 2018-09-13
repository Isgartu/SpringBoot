package com.isgartu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication()// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class ScrapingSpringBootRestApiProducer {

	public static void main(String[] args) {
		SpringApplication.run(ScrapingSpringBootRestApiProducer.class, args);
	}
}
