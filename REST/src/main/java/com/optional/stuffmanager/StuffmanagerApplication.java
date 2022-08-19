package com.optional.stuffmanager;

import com.optional.stuffmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class StuffmanagerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StuffmanagerApplication.class, args);
    }

    @Override
    public void run(String... args) {

    }
}
