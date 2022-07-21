package com.example.springboot.data.service;

import com.example.springboot.data.entities.MentorInternship;
import com.example.springboot.data.repositories.MentorInternShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorInternshipService {

    @Autowired
    private MentorInternShipRepository mentorInternShipRepository;

    public void save(MentorInternship mentorInternship) {
        mentorInternShipRepository.save(mentorInternship);
    }
}
