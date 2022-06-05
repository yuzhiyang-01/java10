package com.yu.week05.code.database.hikari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.yu.week05.code.database.hikari")
public class HikariApplication {

    public static void main(String[] args) {
        SpringApplication.run(HikariApplication.class, args);
    }
}
