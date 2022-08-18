package com.optional.stuffmanager.service;

import com.optional.stuffmanager.document.Role;
import com.optional.stuffmanager.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role createNewRole(String name) {
        return roleRepository.save(new Role(name));
    }

    public Role findRole(String name) {
        return roleRepository.findByName(name);
    }
}
