package com.example.springboot.controller.admin;

import com.example.springboot.data.service.MentorService;
import com.example.springboot.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private MentorService mentorService;

    @GetMapping("/search")
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
        return "/home";
    }

}

