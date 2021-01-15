package com.groupproject.repository;

import com.groupproject.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByTypeIgnoreCase(String type);
}
