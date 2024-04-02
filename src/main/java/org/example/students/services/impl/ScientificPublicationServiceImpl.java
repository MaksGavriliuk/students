package org.example.students.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.students.dtos.ScientificPublicationDTO;
import org.example.students.entities.ScientificPublication;
import org.example.students.exceptions.NotFoundException;
import org.example.students.mappers.ScientificPublicationMapper;
import org.example.students.repositories.ScientificPublicationRepository;
import org.example.students.services.ScientificPublicationService;
import org.example.students.services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ScientificPublicationServiceImpl implements ScientificPublicationService {

    private final ScientificPublicationRepository scientificPublicationRepository;
    private final ScientificPublicationMapper scientificPublicationMapper;
    private final StudentService studentService;


    @Override
    public Page<ScientificPublicationDTO> findScientificPublications(Pageable pageable) {
        return scientificPublicationRepository.findAll(pageable)
                .map(scientificPublicationMapper::toScientificPublicationDTO);
    }

    @Override
    public ScientificPublication findScientificPublicationById(long id) {
        return scientificPublicationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не удалось найти научную публикацию с id = " + id));
    }

    @Override
    public ScientificPublicationDTO getScientificPublicationById(long id) {
        return scientificPublicationMapper.toScientificPublicationDTO(findScientificPublicationById(id));
    }

    @Override
    public void deleteScientificPublicationById(long id) {
        scientificPublicationRepository.deleteById(id);
    }

    @Override
    public ScientificPublicationDTO saveScientificPublication(ScientificPublicationDTO scientificPublicationDTO) {
        studentService.findStudentById(scientificPublicationDTO.studentId());
        ScientificPublication savedScientificPublication = scientificPublicationRepository.save(scientificPublicationMapper.toScientificPublication(scientificPublicationDTO));
        return scientificPublicationMapper.toScientificPublicationDTO(savedScientificPublication);
    }

    @Override
    public ScientificPublicationDTO updateScientificPublication(long id, ScientificPublicationDTO scientificPublicationDTO) {
        studentService.findStudentById(scientificPublicationDTO.studentId());
        ScientificPublication scientificPublication = scientificPublicationMapper
                .toScientificPublication(scientificPublicationDTO)
                .setId(findScientificPublicationById(id).getId());
        ScientificPublication savedScientificPublication = scientificPublicationRepository.save(scientificPublication);
        return scientificPublicationMapper.toScientificPublicationDTO(savedScientificPublication);
    }

    @Override
    public Page<ScientificPublicationDTO> findScientificPublicationsByStudentId(long studentId) {
        return scientificPublicationRepository.findScientificPublicationsByStudentId(studentId)
                .map(scientificPublicationMapper::toScientificPublicationDTO);
    }

}