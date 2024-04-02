package org.example.students.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;


public record StudentDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) @NotNull Long id,
        @NotBlank String surname,
        @NotBlank String name,
        @NotBlank String patronymic,
        @NotBlank String gender,
        @NotBlank @Temporal(TemporalType.DATE) Date dateOfBirth,
        @NotBlank String groupNumber,
        @NotBlank String hometown,
        @NotBlank String address,
        @NotBlank String phoneNumber,
        @NotBlank List<StudentSocialNetworkDTO> socialNetworks
) {
}