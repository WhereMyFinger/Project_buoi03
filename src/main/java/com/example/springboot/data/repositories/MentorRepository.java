package com.example.springboot.data.repositories;

import com.example.springboot.data.entities.Mentor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface MentorRepository extends JpaRepository<Mentor, Integer> {

    public Page<Mentor> findAllByIs_active(Pageable pageable, @Param("is_active") boolean is_active);
}
