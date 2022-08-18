package com.optional.stuffmanager.repository;

import com.optional.stuffmanager.document.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByName(String name);
}
