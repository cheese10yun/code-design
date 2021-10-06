package com.code.design;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Ch7Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch7Application.class, args);
    }
}
