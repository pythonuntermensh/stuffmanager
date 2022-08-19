package com.optional.stuffmanager.service.security;

import com.optional.stuffmanager.document.Employee;
import com.optional.stuffmanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class EmployeeDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee == null) {
            throw new UsernameNotFoundException("Email was not found!");
        }
        return new org.springframework.security.core.userdetails.User(employee.getEmail(),
                employee.getPassword(), getGrantedAuthority(employee));
    }

    private Collection<GrantedAuthority> getGrantedAuthority(Employee employee) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(employee.getRole().toString()));
        return authorities;
    }
}
