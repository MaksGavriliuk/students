package org.example.students.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.students.dtos.SpecialtyDTO;
import org.example.students.entities.Specialty;
import org.example.students.exceptions.NotFoundException;
import org.example.students.mappers.SpecialtyMapper;
import org.example.students.repositories.SpecialtyRepository;
import org.example.students.services.SpecialtyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;
    private final SpecialtyMapper specialtyMapper;


    @Override
    public Page<SpecialtyDTO> findSpecialties(Pageable pageable) {
        return specialtyRepository.findAll(pageable)
                .map(specialtyMapper::toSpecialtyDTO);
    }

    @Override
    public Specialty findSpecialtyById(long id) {
        return specialtyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не удалось найти специальность с id = " + id));
    }

    @Override
    public SpecialtyDTO getSpecialtyById(long id) {
        return specialtyMapper.toSpecialtyDTO(findSpecialtyById(id));
    }

    @Override
    public void deleteSpecialtyById(long id) {
        specialtyRepository.deleteById(id);
    }

    @Override
    public SpecialtyDTO saveSpecialty(SpecialtyDTO studentDTO) {
        Specialty savedSpecialty = specialtyRepository.save(specialtyMapper.toSpecialty(studentDTO));
        return specialtyMapper.toSpecialtyDTO(savedSpecialty);
    }

    @Override
    public SpecialtyDTO updateSpecialty(long id, SpecialtyDTO specialtyDTO) {
        Specialty specialty = specialtyMapper
                .toSpecialty(specialtyDTO)
                .setId(findSpecialtyById(id).getId());
        Specialty savedSpecialty = specialtyRepository.save(specialty);
        return specialtyMapper.toSpecialtyDTO(savedSpecialty);
    }

}