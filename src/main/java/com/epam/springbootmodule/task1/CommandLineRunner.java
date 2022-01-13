package com.epam.springbootmodule.task1;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("task1")
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("Hello, world!");
    }

}
