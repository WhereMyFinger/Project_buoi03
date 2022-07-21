package com.example.springboot.data.repositories;

import com.example.springboot.data.entities.Internship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternshipRepository extends JpaRepository<Internship, Integer> {
}
