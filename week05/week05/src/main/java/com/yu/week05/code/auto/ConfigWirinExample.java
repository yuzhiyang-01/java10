package com.yu.week05.code.auto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigWirinExample {

    @Bean
    public String message(){
        return "Hello Config Bean";
    }
}
