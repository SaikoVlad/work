package com.example.prostrmk.demo;

import com.example.prostrmk.demo.model.UserDetailsServiceImpl;
import com.example.prostrmk.demo.model.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        BCryptPasswordEncoder c = new BCryptPasswordEncoder();
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

}
