package org.example.students.services;

import org.example.students.dtos.SpecialtyDTO;
import org.example.students.entities.Specialty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface SpecialtyService {

    Page<SpecialtyDTO> findSpecialties(Pageable pageable);

    Specialty findSpecialtyById(long id);

    SpecialtyDTO getSpecialtyById(long id);

    void deleteSpecialtyById(long id);

    SpecialtyDTO saveSpecialty(SpecialtyDTO studentDTO);

    SpecialtyDTO updateSpecialty(long id, SpecialtyDTO specialtyDTO);

}