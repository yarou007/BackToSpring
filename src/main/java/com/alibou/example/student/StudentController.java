package com.alibou.example.student;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {


  private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDTO saveStudent(
             @RequestBody  @Valid  StudentDTO studentDTO
    ){
           return this.studentService.saveStudent(studentDTO);
    }




    @GetMapping("/students")
    public List<StudentResponseDTO> getAllStudents(){

      return this.studentService.findAllStudents();
    }


    @GetMapping("/students/{student-id}")
    public Optional<StudentResponseDTO> getStudentById(
            @PathVariable ("student-id") Integer id
    ){
          return this.studentService.findById(id);
    }
    @GetMapping("/students/age/{student-age}")
    public List<Student> getStudentByAge(
            @PathVariable ("student-age") int age
    ){
        return this.studentService.findByAge(age);
    }
    @GetMapping("/students/name/{student-name}")
    public List<StudentResponseDTO> getStudentByName(
            @PathVariable ("student-name") String firstName
    ){
        return this.studentService.findByFirstNameContaining(firstName);
    }

    @DeleteMapping("/students/{id}")
    public List<Student> deleteById(@PathVariable ("id") Integer id){
        return this.studentService.deleteById(id);
    }

    @ExceptionHandler
  public ResponseEntity<?> handleExceptionNotValid( MethodArgumentNotValidException ex){

      var errors = new HashMap<String,String>();
      ex.getBindingResult().getAllErrors()
              .forEach(error -> {
                var fieldName = ((FieldError) error).getField();
                var errorMessage = error.getDefaultMessage();
                errors.put(fieldName,errorMessage);
              });
      return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
