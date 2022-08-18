package com.optional.stuffmanager.repository;

import com.optional.stuffmanager.document.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findByEmail(String email);
}
