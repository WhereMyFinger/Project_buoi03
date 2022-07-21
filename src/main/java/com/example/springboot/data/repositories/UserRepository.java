package com.example.springboot.data.repositories;

import com.example.springboot.data.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional(readOnly = true)
    Iterable<User> findUsersByUsername(@Param("username") String username);

    Page<User> findUsersByUsernameContaining(Pageable pageable, @Param("name") String name);

    Iterable<User> findByEmail(@Param("email") String email);

    Page<User> findUsersByRoleAndAndIs_del_flg(Pageable pageable, @Param("role") int role, @Param("is_del_flg") boolean is_del_flg);
}
