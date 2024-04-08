package org.example.students.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public record StudentDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) @NotNull Long id,
        @NotBlank String surname,
        @NotBlank String name,
        @NotBlank String patronymic,
        @NotBlank String gender,
        @NotBlank @Temporal(TemporalType.DATE) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth,
        @NotBlank Long groupId,
        @NotBlank String hometown,
        @NotBlank String address,
        @NotBlank String phoneNumber
) {
}