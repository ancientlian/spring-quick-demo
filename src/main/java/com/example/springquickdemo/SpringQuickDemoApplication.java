package com.example.springquickdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class SpringQuickDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringQuickDemoApplication.class, args);
    }

}
