package org.example.students.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record SpecialtyDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) @NotNull Long id,
        @NotBlank String name
) {
}