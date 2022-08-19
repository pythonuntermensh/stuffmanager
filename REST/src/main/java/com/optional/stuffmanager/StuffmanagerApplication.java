package com.optional.stuffmanager;

import com.optional.stuffmanager.document.Employee;
import com.optional.stuffmanager.exception.EmployeeAlreadyExistsException;
import com.optional.stuffmanager.role.Role;
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

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... args) {
        Employee employee = new Employee("Optional", Role.CEO, 50000, "maxprokofievofficial@mail.ru", "alwayswannadrunk");
        try {
            employeeService.createNewEmployee(employee);
        } catch (EmployeeAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
}
