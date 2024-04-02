package org.example.students.mappers;


import org.example.students.dtos.ScientificPublicationDTO;
import org.example.students.entities.ScientificPublication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface ScientificPublicationMapper {

    @Mapping(source = "studentId", target = "student.id")
    ScientificPublication toScientificPublication(ScientificPublicationDTO scientificPublicationDTO);

    @Mapping(source = "student.id", target = "studentId")
    ScientificPublicationDTO toScientificPublicationDTO(ScientificPublication scientificPublication);

}