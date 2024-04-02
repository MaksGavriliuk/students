package org.example.students.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;


public record ScientificPublicationDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) @NotNull Long id,
        @NotBlank String journal,
        @NotBlank String publicationTitle,
        @NotBlank @Temporal(TemporalType.DATE) Date publicationDate,
        @NotNull long studentId
) {
}