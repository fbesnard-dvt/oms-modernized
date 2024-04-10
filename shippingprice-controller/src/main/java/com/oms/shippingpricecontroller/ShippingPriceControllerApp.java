package com.oms.shippingpricecontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ImportResource({ "spring-config.xml" })
@EntityScan(basePackages = { "com.oms.entity" })
public class ShippingPriceControllerApp {
    public static void main(String[] args)
    {
        SpringApplication.run(ShippingPriceControllerApp.class, args);
    }
}