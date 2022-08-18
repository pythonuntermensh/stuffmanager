package com.optional.stuffmanager.service;

import com.optional.stuffmanager.document.Employee;
import com.optional.stuffmanager.repository.EmployeeRepository;
import com.optional.stuffmanager.role.Role;
import com.optional.stuffmanager.util.EmployeesFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll(String name, Role role, String email) {
        EmployeesFilter employeesFilter = new EmployeesFilter(employeeRepository.findAll());
        return new ArrayList<>(employeesFilter.filterName(name).filterRole(role).filterEmail(email).toList());
    }

    public void createNewEmployee(String name, Role role, int salary, String email, String password) {
        Employee employee = new Employee(name, role, salary, email, password);
        employeeRepository.save(employee);
    }
}
