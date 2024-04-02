package org.example.students.mappers;


import org.example.students.dtos.SpecialtyDTO;
import org.example.students.entities.Specialty;
import org.mapstruct.Mapper;


@Mapper
public interface SpecialtyMapper {

    Specialty toSpecialty(SpecialtyDTO specialtyDTO);

    SpecialtyDTO toSpecialtyDTO(Specialty specialty);

}