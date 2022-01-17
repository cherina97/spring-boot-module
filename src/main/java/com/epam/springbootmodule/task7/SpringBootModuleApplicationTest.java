package com.epam.springbootmodule.task7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("test")
@SpringBootApplication
public class SpringBootModuleApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootModuleApplicationTest.class, args);
    }

}
