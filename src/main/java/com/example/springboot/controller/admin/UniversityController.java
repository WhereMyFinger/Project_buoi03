package com.example.springboot.controller.admin;

import com.example.springboot.data.entities.University;
import com.example.springboot.data.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping("university_index")
    public String getAllUniversity(Model model,
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

        model.addAttribute("university", universityService.getAllUniversity(pageable));
        return "";
    }

    @GetMapping("add_new_university_form")
    public String showAddNewForm(Model model, University university) {
        model.addAttribute("university", university);
        return "add-university-form";
    }

    @PostMapping("add_university")
    public String addUniversity(University university) {
        university.setIs_del_flg(false);
        university.setCreated_at(new Date());
        universityService.saveUniversity(university);
        return "";
    }

    @GetMapping("update_university_form")
    public String showUpdateForm(Model model, int id) {
        model.addAttribute("university", universityService.getUniversityById(id));
        return "update-university-form";
    }

    @PutMapping("update_university")
    public String update(University university) {
        university.setModified_at(new Date());
        universityService.saveUniversity(university);
        return "";
    }

    @DeleteMapping("delete_university")
    public String delete(int id) {
        universityService.deleteUniversity(id);
        return "";
    }
}
