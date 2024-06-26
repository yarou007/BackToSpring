package com.alibou.example.student;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {


    private final StudentRepository studentRepository;


    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDTO saveStudent(StudentDTO studentDTO){
        var s = studentMapper.toStudent(studentDTO);
        var savedStudent =    studentRepository.save(s);
        return studentMapper.toStudentResponseDto(savedStudent);
    }



    public List<StudentResponseDTO> findAllStudents(){
         return this.studentRepository.findAll()
                 .stream()
                 .map(studentMapper::toStudentResponseDto)
                 .collect(Collectors.toList());
    }

    public Optional<StudentResponseDTO> findById(Integer id){
        return this.studentRepository.findById(id)
                .map(studentMapper::toStudentResponseDto)
                ;
    }

    public  List<Student> findByAge(int age){
        return this.studentRepository.findByAge(age);
    }

    public List<StudentResponseDTO> findByFirstNameContaining(String name){
        return this.studentRepository.findByFirstNameContaining(name)
                .stream().map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());

    }
    public List<Student> deleteById(Integer id){
        studentRepository.deleteById(id);
        return studentRepository.findAll();
    }
}
