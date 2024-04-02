package org.example.students.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record StudentSocialNetworkDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) @NotNull Long id,
        @NotNull long socialNetworkId,
        @NotNull long studentId,
        @NotBlank String link
) {
}