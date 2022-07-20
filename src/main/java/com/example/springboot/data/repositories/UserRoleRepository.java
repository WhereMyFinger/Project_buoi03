package com.example.springboot.data.repositories;

import com.example.springboot.data.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    @Transactional(readOnly = true)
    Iterable<UserRole> findUserRolesById(@Param("id") int userId);
}
