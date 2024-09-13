package com.example.saso.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SecurityConfigTest {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Test
    void pwdTest(){
        String pwd = passwordEncoder.encode("1234");
        System.out.println(pwd);
    }
}
