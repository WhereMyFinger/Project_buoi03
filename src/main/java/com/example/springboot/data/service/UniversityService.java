package com.example.springboot.data.service;

import com.example.springboot.data.entities.University;
import com.example.springboot.data.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    public Page<University> getAllUniversity(Pageable pageable) {
        return universityRepository.findAll(pageable);
    }

    public University getUniversityById(int id) {
        return universityRepository.findById(id).get();
    }

    public Page<University> getUniversitiesByNameContaining(Pageable pageable, String name) {
        return universityRepository.findAllByNameContaining(pageable, name);
    }

    public void saveUniversity(University university) {
        universityRepository.save(university);
    }

    public void deleteUniversity(int id) {
        University university = universityRepository.findById(id).get();
        university.setIs_del_flg(true);
        university.setModified_at(new Date());
        universityRepository.save(university);
    }
}
