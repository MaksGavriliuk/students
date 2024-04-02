package org.example.students.services;

import org.example.students.dtos.ScientificPublicationDTO;
import org.example.students.entities.ScientificPublication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ScientificPublicationService {

    Page<ScientificPublicationDTO> findScientificPublications(Pageable pageable);

    ScientificPublication findScientificPublicationById(long id);

    ScientificPublicationDTO getScientificPublicationById(long id);

    void deleteScientificPublicationById(long id);

    ScientificPublicationDTO saveScientificPublication(ScientificPublicationDTO studentDTO);

    ScientificPublicationDTO updateScientificPublication(long id, ScientificPublicationDTO specialtyDTO);

    Page<ScientificPublicationDTO> findScientificPublicationsByStudentId(long studentId);
    
}