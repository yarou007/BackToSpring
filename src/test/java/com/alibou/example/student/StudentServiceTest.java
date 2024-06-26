package com.alibou.example.student;

import jakarta.inject.Inject;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StudentServiceTest {
   // which server we want to test
    @InjectMocks
    private StudentService studentService;

   // declare dependecies
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }




    @Test
    public void Should_Save_Student(){
           //Given
        StudentDTO dto = new StudentDTO("John","Doe","john@gmail.com",1);
        Student student = new Student("John","Doe","john@gmail.com",20);
        Student savedStudent = new Student("John","Doe","john@gmail.com",20);
        savedStudent.setId(1);

        //Mock the calls
        when(studentMapper.toStudent(dto)).thenReturn(student);

        when(studentRepository.save(student)).thenReturn(savedStudent);

        when(studentMapper.toStudentResponseDto(savedStudent)).thenReturn(new StudentResponseDTO("John","Doe","john@gmail.com"));

        //When
        StudentResponseDTO responseDTO = studentService.saveStudent(dto);

        //then
        assertEquals(dto.firstName(),responseDTO.firstName());
        assertEquals(dto.lastName(),responseDTO.lastName());
        assertEquals(dto.email(),responseDTO.email());

        verify(studentMapper,times(1)).toStudent(dto);
        verify(studentRepository,times(1)).save(student);
        verify(studentMapper,times(1)).toStudentResponseDto(savedStudent);


    }
}