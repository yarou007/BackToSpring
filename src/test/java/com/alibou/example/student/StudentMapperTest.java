package com.alibou.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {


    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent(){
         StudentDTO dto = new StudentDTO("John","Doe","john@gmail.com",1);

         Student student = mapper.toStudent(dto);
        assertEquals(dto.firstName() , student.getfirstName());
        assertEquals(dto.lastName() , student.getlastName());
        assertEquals(dto.email() , student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId() , student.getSchool().getId());
    }


   @Test
    public void shouldThrowNullPointerExceptionWhenStudentDtoIsNull(){
        var msg =  assertThrows(NullPointerException.class,()-> mapper.toStudent( null) );
         assertEquals("The studentDto should not be null",msg.getMessage());


    }
    @Test
    public void shouldMapStudentToStudentResponseDto(){
        // Given student object
        Student student = new Student("John","Doe","john@gmail.com",20);
        // When we student to dtoResponse
        StudentResponseDTO dtoResponse = mapper.toStudentResponseDto(student);
        //Then i'm expecting these results
        assertEquals(student.getfirstName(),dtoResponse.firstName());
        assertEquals(student.getlastName(),dtoResponse.lastName());
        assertEquals(student.getEmail(),dtoResponse.email());

    }
}