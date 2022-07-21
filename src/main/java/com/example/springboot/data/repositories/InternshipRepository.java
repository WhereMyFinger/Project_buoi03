package com.example.springboot.data.repositories;

import com.example.springboot.data.entities.Internship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface InternshipRepository extends JpaRepository<Internship, Integer> {

    public Page<Internship> findAllByStatus(Pageable pageable, @Param("status") int status);
}
