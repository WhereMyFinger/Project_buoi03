package com.example.springboot.data.repositories;

import com.example.springboot.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional(readOnly = true)
    Iterable<User> findUsersByUsername(@Param("username") String username);
}
