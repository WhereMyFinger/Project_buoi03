package com.example.springboot.controller.admin;

import com.example.springboot.data.entities.Mentor;
import com.example.springboot.data.entities.User;
import com.example.springboot.data.service.MentorService;
import com.example.springboot.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class MentorManagingController {

    @Autowired
    private UserService userService;

    @Autowired
    private MentorService mentorService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/mentor_index")
    public String getAllMentor(Model model,
                               @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                               @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                               @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
        Sort sortable = null;
        if(sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if(sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);

        model.addAttribute("user", userService.findUsersByRole(pageable, 2, false));
        model.addAttribute("mentor", mentorService.getAllMentor(pageable, true));
        return "";
    }

    @GetMapping("/add_mentor_form")
    public String showAddMentorForm(Model model, Mentor mentor, User user) {
        model.addAttribute("user", user);
        model.addAttribute("mentor", mentor);
        return "add-mentor-form";
    }

    @PostMapping("/add_mentor")
    public String addNewMentor(@RequestBody User user, Mentor mentor) {
        // hash pass
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreated_at(new Date());
        user.setIs_del_flg(false);
        userService.saveUser(user);

        mentor.setUser_id(user.getId());
        mentor.setIs_active(true);
        mentorService.saveMentor(mentor);

        return "success";
    }

    @GetMapping("/update_mentor_form")
    public String showUpdateMentorForm(int id) {
        Mentor mentor = mentorService.getMentorById(id);
        User user = userService.findUserById(id);
        return "update-mentor-form";
    }

    @PutMapping("/update_mentor")
    public String updateMentor(Mentor mentor, User user) {
        mentorService.saveMentor(mentor);
        user.setModified_at(new Date());
        userService.saveUser(user);
        return "success";
    }

    @DeleteMapping("/delete_mentor")
    public String deleteMentor(int id) {
        mentorService.deleteMentor(id);
        return "success";
    }
}
