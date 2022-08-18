package com.optional.stuffmanager.util;

import com.optional.stuffmanager.document.Employee;
import com.optional.stuffmanager.role.Role;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class EmployeesFilter {

    private List<Employee> employeesList;

    public EmployeesFilter(List<Employee> employeesList) { this.employeesList = employeesList; }

    public EmployeesFilter filterName(String name) {
        if (name != null) {
            employeesList = employeesList.stream().filter(e -> e.getName().toLowerCase().contains(name)).collect(Collectors.toList());
        }
        return this;
    }

    public EmployeesFilter filterRole(Role role) {
        if (role != null) {
            employeesList = employeesList.stream().filter(e -> e.getRole() == role).collect(Collectors.toList());
        }
        return this;
    }

    public EmployeesFilter filterEmail(String email) {
        if (email != null) {
            employeesList = employeesList.stream().filter(e -> e.getEmail().toLowerCase().contains(email)).collect(Collectors.toList());
        }
        return this;
    }

    public List<Employee> toList() {
        return employeesList;
    }
}
