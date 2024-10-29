package com.asree.stock_spring_boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StockSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockSpringBootApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner -> {
            System.out.println("------------------------");
            System.out.println("Start Server Port: 3333");
            System.out.println("------------------------");
        };
    }

}
