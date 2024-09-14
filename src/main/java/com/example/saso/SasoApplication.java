package com.example.saso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class SasoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SasoApplication.class, args);
    }

}
