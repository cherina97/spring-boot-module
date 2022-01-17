package com.epam.springbootmodule.task2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("task2")
@SpringBootApplication
public class SpringBootModuleApplicationTask2 {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootModuleApplicationTask2.class, args);
    }

}
