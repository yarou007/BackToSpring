package com.alibou.example.student;


import com.alibou.example.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public StudentResponseDTO toStudentResponseDto(Student student){
        return new StudentResponseDTO(student.getfirstName(),student.getlastName(),student.getEmail());
    }

    public Student toStudent(StudentDTO dto){
        if (dto == null){
            throw new NullPointerException("The studentDto should not be null");
        }
        var student = new Student();
        student.setfirstName(dto.firstName());
        student.setlastName(dto.lastName());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);
        return student;
    }
}
