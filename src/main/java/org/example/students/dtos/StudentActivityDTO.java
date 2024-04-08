package org.example.students.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record StudentActivityDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) @NotNull Long id,
        @NotBlank String description,
        @NotBlank @Temporal(TemporalType.DATE) @DateTimeFormat(pattern = "yyyy-MM-dd") Date activityDate,
        @NotNull long studentId
) {
}
