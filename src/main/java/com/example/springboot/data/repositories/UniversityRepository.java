package com.example.springboot.data.repositories;

import com.example.springboot.data.entities.University;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UniversityRepository extends JpaRepository<University, Integer> {

    public Page<University> findAllByNameContaining(Pageable pageable, @Param("name") String name);
}
