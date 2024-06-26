package com.alibou.example.school;


import org.springframework.stereotype.Service;

@Service
public class SchoolServiceMapper {

    public School ToSchool(SchoolDTO dto){
        return new School(dto.name() );

    }


    public SchoolDTO toSchoolDto(School school){
        return new SchoolDTO(school.getName());

    }
}
