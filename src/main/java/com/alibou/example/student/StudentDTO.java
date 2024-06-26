package com.alibou.example.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDTO(
         @NotEmpty(message = "First name should not be empty patron ")
         String firstName,
         @NotEmpty(message = "Last name should not be empty patron ")
         String lastName,

         String email,
         Integer schoolId

) {
}
