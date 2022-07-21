package com.example.springboot.controller.admin;

import com.example.springboot.data.entities.Internship;
import com.example.springboot.data.entities.Mentor;
import com.example.springboot.data.entities.User;
import com.example.springboot.data.service.InternshipService;
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
public class InternshipManagingController {

    @Autowired
    private UserService userService;

    @Autowired
    private InternshipService internshipService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/Internship_index")
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

        model.addAttribute("user", userService.findUsersByRole(pageable, 3, false));
        model.addAttribute("internship", internshipService.getAllInternship(pageable, 1));
        return "";
    }

    /*@GetMapping("/search")
    public String search(Model model,
                         @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                         @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                         @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                         @RequestParam String name) {
        Sort sortable = null;
        if(sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if(sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);

        model.addAttribute("users", userService.findUserByNameContaining(pageable, name));
        model.addAttribute("internship", internshipService.)
        return "/home";
    }*/

    @GetMapping("/add_internship_form")
    public String showAddMentorForm(int id) {
        Internship internship = internshipService.getInternshipById(id);
        User user = userService.findUserById(id);
        return "add-intership-form";
    }

    @PostMapping("/add_internship")
    public String addNewMentor(@RequestBody User user, Internship internship) {
        // hash pass
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreated_at(new Date());
        user.setIs_del_flg(false);
        userService.saveUser(user);

        internship.setUser_id(user.getId());
        internship.setStatus(1);
        internshipService.saveInternship(internship);

        return "success";
    }

    @GetMapping("/update_internship_form")
    public String showUpdateMentorForm(int id) {
        Internship internship = internshipService.getInternshipById(id);
        User user = userService.findUserById(id);
        return "update-mentor-form";
    }

    @PutMapping("/update_mentor")
    public String updateMentor(Internship internship, User user) {
        internshipService.saveInternship(internship);
        user.setModified_at(new Date());
        userService.saveUser(user);
        return "success";
    }

    @DeleteMapping("/delete_mentor")
    public String deleteMentor(int id) {
        userService.deleteUser(id);
        internshipService.deleteInternship(id);
        return "success";
    }
}
