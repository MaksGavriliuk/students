package org.example.students.dtos;


import jakarta.validation.constraints.NotBlank;

import java.util.Date;


public record StudentDTO(
        @NotBlank String surname,
        @NotBlank String name,
        @NotBlank String patronymic,
        @NotBlank String gender,
        @NotBlank Date dateOfBirth,
        @NotBlank String groupNumber
) {
}