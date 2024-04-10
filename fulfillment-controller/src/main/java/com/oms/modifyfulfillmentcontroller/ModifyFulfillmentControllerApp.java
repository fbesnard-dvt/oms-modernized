package com.oms.modifyfulfillmentcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@ImportResource({"META-INF/rr/**/*.xml"})
@ImportResource({ "spring-config.xml" })
@EntityScan(basePackages = { "com.oms.entity" })
public class ModifyFulfillmentControllerApp {
    public static void main(String[] args)
    {
        SpringApplication.run(ModifyFulfillmentControllerApp.class, args);
    }
}