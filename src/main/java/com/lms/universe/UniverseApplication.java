package com.lms.universe;

import com.lms.universe.config.ApplicationConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
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
