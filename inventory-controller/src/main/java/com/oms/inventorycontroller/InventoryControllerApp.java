package com.oms.inventorycontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({ "spring-config.xml" })
@EntityScan(basePackages = { "com.oms.entity" })
public class InventoryControllerApp {
	public static void main(String[] args) {
		SpringApplication.run(InventoryControllerApp.class, args);
	}
}