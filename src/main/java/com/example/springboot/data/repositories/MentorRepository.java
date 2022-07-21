package com.example.springboot.data.repositories;

import com.example.springboot.data.entities.Mentor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor, Integer> {
}
