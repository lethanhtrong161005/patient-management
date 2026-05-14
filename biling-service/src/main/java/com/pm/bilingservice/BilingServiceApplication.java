package com.pm.bilingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.pm" })
public class BilingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BilingServiceApplication.class, args);
    }

}
