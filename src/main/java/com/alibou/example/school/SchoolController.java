package com.alibou.example.school;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {



   private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolDTO createSchool(@RequestBody SchoolDTO dto){
         return schoolService.createSchool(dto);
    }

    @GetMapping("/schools")
    public List<SchoolDTO> getAllSchool(){
        return  schoolService.getAllSchool();
    }
}
