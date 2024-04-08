package org.example.students.controllers;

import lombok.RequiredArgsConstructor;
import org.example.students.dtos.ScientificPublicationDTO;
import org.example.students.repositories.ScientificPublicationRepository;
import org.example.students.services.ScientificPublicationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/scientific-publications")
@RequiredArgsConstructor
public class ScientificPublicationController {

    private final ScientificPublicationService scientificPublicationService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ScientificPublicationDTO> getScientificPublications(Pageable pageable) {
        return scientificPublicationService.findScientificPublications(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ScientificPublicationDTO getScientificPublicationById(@PathVariable long id) {
        return scientificPublicationService.getScientificPublicationById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScientificPublicationDTO createScientificPublication(@RequestBody ScientificPublicationDTO scientificPublicationDTO) {
        return scientificPublicationService.saveScientificPublication(scientificPublicationDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ScientificPublicationDTO updateScientificPublication(
            @PathVariable long id,
            @RequestBody ScientificPublicationDTO scientificPublicationDTO
    ) {
        return scientificPublicationService.updateScientificPublication(id, scientificPublicationDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteScientificPublication(@PathVariable long id) {
        scientificPublicationService.deleteScientificPublicationById(id);
    }

    @GetMapping("/student/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    Page<ScientificPublicationDTO> findScientificPublicationsByStudentId(@PathVariable long studentId, Pageable pageable){
        return scientificPublicationService.findScientificPublicationsByStudentId(studentId, pageable);
    }

}