package com.example.springboot.data.service;

import com.example.springboot.data.entities.Mentor;
import com.example.springboot.data.entities.User;
import com.example.springboot.data.repositories.MentorRepository;
import com.example.springboot.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    public Mentor getMentorById(int id) {
        return mentorRepository.findById(id).get();
    }

    public Page<Mentor> getAllMentor(Pageable pageable, boolean is_active) {
        return mentorRepository.findAllByIs_active(pageable, is_active);
    }

    public void deleteMentor(int id) {
        Mentor mentor = mentorRepository.getById(id);
        mentor.setIs_active(false);
    }

    public void saveMentor(Mentor mentor) {
        mentorRepository.save(mentor);
    }
}
