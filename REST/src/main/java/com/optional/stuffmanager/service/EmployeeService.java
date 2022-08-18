package com.optional.stuffmanager.service;

import com.optional.stuffmanager.document.Employee;
import com.optional.stuffmanager.exception.EmployeeAlreadyExistsException;
import com.optional.stuffmanager.exception.NoSuchEmployeeException;
import com.optional.stuffmanager.repository.EmployeeRepository;
import com.optional.stuffmanager.job.Job;
import com.optional.stuffmanager.util.EmployeesFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public List<Employee> findAll(String name, Job role, String email) {
        EmployeesFilter employeesFilter = new EmployeesFilter(employeeRepository.findAll());
        return new ArrayList<>(employeesFilter.filterName(name).filterRole(role).filterEmail(email).toList());
    }

    public void createNewEmployee(String name, Job role, int salary, String email, String password) throws EmployeeAlreadyExistsException {
        if (employeeRepository.findByEmail(email) != null) {
            throw new EmployeeAlreadyExistsException();
        }

        Employee employee = new Employee(name, role, salary, email, new BCryptPasswordEncoder().encode(password));
        employeeRepository.save(employee);
    }

    public void createNewEmployee(Employee employee) throws EmployeeAlreadyExistsException {
        if (employeeRepository.findByEmail(employee.getEmail()) != null) {
            throw new EmployeeAlreadyExistsException();
        }
        employee.setPassword(new BCryptPasswordEncoder().encode(employee.getPassword()));
        employeeRepository.save(employee);
    }

    public void deleteEmployee(String email) throws NoSuchEmployeeException {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee == null) {
            throw new NoSuchEmployeeException();
        }

        employeeRepository.delete(employee);
    }

    public void updateEmployee(String name, Job role, int salary, String email, String password) throws NoSuchEmployeeException {
        Employee employee = employeeRepository.findByEmail(email);

        if (employee == null) {
            throw new NoSuchEmployeeException();
        }

        employee.setName(name);
        employee.setJob(role);
        employee.setSalary(salary);
        employee.setEmail(email);
        employee.setPassword(new BCryptPasswordEncoder().encode(password));
    }
}
