package com.alibou.example.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    private SchoolServiceMapper schoolServiceMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolServiceMapper schoolServiceMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolServiceMapper = schoolServiceMapper;
    }

    public SchoolDTO createSchool(SchoolDTO dto){

        var school = this.schoolServiceMapper.ToSchool(dto);
        var savedSchool= this.schoolRepository.save(school);
        return dto;
    }

    public List<SchoolDTO> getAllSchool(){
        return  this.schoolRepository.findAll()
                .stream()
                .map(this.schoolServiceMapper::toSchoolDto)
                .collect(Collectors.toList());
    }
}
