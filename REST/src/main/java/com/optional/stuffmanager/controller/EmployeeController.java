package com.optional.stuffmanager.controller;


import com.optional.stuffmanager.document.Employee;
import com.optional.stuffmanager.role.Role;
import com.optional.stuffmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    @ResponseBody
    public List<Employee> getAllEmployees(@RequestParam(required = false) String name,
                                          @RequestParam(required = false) Role role,
                                          @RequestParam(required = false) String email) {
        return employeeService.findAll(name, role, email);
    }

    @PostMapping()
    @ResponseBody
    public int newEmployee(String name, Role role, int salary, String email, String password) {
        if (name == null || role == null || email == null || password == null) {
            return 400;
        }
        employeeService.createNewEmployee(name, role, salary, email, password);
        return 200;
    }
}
