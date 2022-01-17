package com.epam.springbootmodule.task5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("task5")
@SpringBootApplication
public class SpringBootModuleApplicationTask5 {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootModuleApplicationTask5.class, args);
    }

}
