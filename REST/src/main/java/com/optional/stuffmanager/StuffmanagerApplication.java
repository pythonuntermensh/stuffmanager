package com.optional.stuffmanager;

import com.optional.stuffmanager.document.Employee;
import com.optional.stuffmanager.document.Role;
import com.optional.stuffmanager.job.Job;
import com.optional.stuffmanager.service.EmployeeService;
import com.optional.stuffmanager.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class StuffmanagerApplication implements CommandLineRunner {

    @Autowired
    private RoleService roleService;

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(StuffmanagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        roleService.createNewRole("admin");
        roleService.createNewRole("manager");
        roleService.createNewRole("accountant");
        roleService.createNewRole("cleaner");
        roleService.createNewRole("securityguard");

        Employee employee = new Employee("Optional", Job.CEO, 50000, "maxprokofievofficial@mail.ru", "alwayswannadrunk");
        employee.setRole(roleService.findRole("admin"));
        employeeService.createNewEmployee(employee);
    }
}
