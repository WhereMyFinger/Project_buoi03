package com.example.springboot.controller.admin;

import com.example.springboot.data.service.MentorService;
import com.example.springboot.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private MentorService mentorService;

    @GetMapping("/home")
    public String showAllMentor() {

        return "/home";
    }

}

