package com.optional.stuffmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class StuffmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuffmanagerApplication.class, args);
    }

}
