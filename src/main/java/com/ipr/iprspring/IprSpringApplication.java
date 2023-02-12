package com.ipr.iprspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class IprSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(IprSpringApplication.class, args);
    }

}
