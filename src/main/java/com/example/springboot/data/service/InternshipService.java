package com.example.springboot.data.service;

import com.example.springboot.data.entities.Internship;
import com.example.springboot.data.repositories.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InternshipService {

    @Autowired
    private InternshipRepository internshipRepository;

    public Internship getInternshipById(int id) {
        return internshipRepository.findById(id).get();
    }

    public Page<Internship> getAllInternship(Pageable pageable, int status) {
        return internshipRepository.findAllByStatus(pageable, status);
    }

    public void saveInternship(Internship internship) {
        internshipRepository.save(internship);
    }

    public void deleteInternship(int id) {
        Internship internship = internshipRepository.findById(id).get();
        internship.setStatus(0);
    }
}
