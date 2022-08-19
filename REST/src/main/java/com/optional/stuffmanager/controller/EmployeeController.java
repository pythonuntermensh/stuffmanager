package com.optional.stuffmanager.controller;


import com.optional.stuffmanager.document.Employee;
import com.optional.stuffmanager.exception.EmployeeAlreadyExistsException;
import com.optional.stuffmanager.exception.NoSuchEmployeeException;
import com.optional.stuffmanager.role.Role;
import com.optional.stuffmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/new")
    @ResponseBody
    public ResponseEntity newEmployee(String name, Role role, int salary, String email, String password) {
        if (name == null || role == null || email == null || password == null) {
            return ResponseEntity.badRequest().body(400);
        }

        try {
            employeeService.createNewEmployee(name, role, salary, email, password);
            return ResponseEntity.ok(200);
        } catch (EmployeeAlreadyExistsException err) {
            return ResponseEntity.ok(400);
        }
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity deleteEmployee(String email) {
        if (email == null) {
            return ResponseEntity.badRequest().body(400);
        }

        try {
            employeeService.deleteEmployee(email);
            return ResponseEntity.ok(200);
        } catch (NoSuchEmployeeException err) {
            return ResponseEntity.badRequest().body(400);
        }
    }


}
