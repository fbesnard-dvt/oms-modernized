package com.oms.ordercontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({ "spring-config.xml" })
@EntityScan(basePackages = { "com.oms.entity" })
public class OrderControllerApp {
	public static void main(String[] args) {
		SpringApplication.run(OrderControllerApp.class, args);
	}
}