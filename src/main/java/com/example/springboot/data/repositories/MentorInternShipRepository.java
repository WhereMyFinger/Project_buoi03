package com.example.springboot.data.repositories;

import com.example.springboot.data.entities.MentorInternship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorInternShipRepository extends JpaRepository<MentorInternship, Integer> {
}
