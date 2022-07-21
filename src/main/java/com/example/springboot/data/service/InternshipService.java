package com.example.springboot.data.service;

import com.example.springboot.data.repositories.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternshipService {

    @Autowired
    private InternshipRepository internshipRepository;


}
