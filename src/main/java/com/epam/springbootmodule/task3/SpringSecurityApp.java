package com.epam.springbootmodule.task3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("task3")
@SpringBootApplication
public class SpringSecurityApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApp.class, args);
    }
}
