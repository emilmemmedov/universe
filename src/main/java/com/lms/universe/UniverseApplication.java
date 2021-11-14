package com.lms.universe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackages = "com.lms")
public class UniverseApplication{

    public static void main(String[] args) {
        SpringApplication.run(UniverseApplication.class, args);
    }

}
