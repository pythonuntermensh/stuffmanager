package com.optional.stuffmanager.setup;

import com.optional.stuffmanager.document.Employee;
import com.optional.stuffmanager.exception.EmployeeAlreadyExistsException;
import com.optional.stuffmanager.role.Role;
import com.optional.stuffmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.transaction.annotation.Transactional;

public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private EmployeeService employeeService;


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        Employee employee = new Employee("Optional", Role.CEO, 50000, "maxprokofievofficial@mail.ru", "alwayswannadrunk");
        try {
            employeeService.createNewEmployee(employee);
        } catch (EmployeeAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
}
