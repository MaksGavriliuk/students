package org.example.students.controllers;

import lombok.RequiredArgsConstructor;
import org.example.students.dtos.SpecialtyDTO;
import org.example.students.services.SpecialtyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/specialties")
@RequiredArgsConstructor
public class SpecialtyController {

    private final SpecialtyService specialtyService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<SpecialtyDTO> getSpecialties(Pageable pageable) {
        return specialtyService.findSpecialties(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SpecialtyDTO getSpecialtyById(@PathVariable long id) {
        return specialtyService.getSpecialtyById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SpecialtyDTO createSpecialty(@RequestBody SpecialtyDTO specialtyDTO) {
        return specialtyService.saveSpecialty(specialtyDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SpecialtyDTO updateSpecialty(
            @PathVariable long id,
            @RequestBody SpecialtyDTO specialtyDTO
    ) {
        return specialtyService.updateSpecialty(id, specialtyDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSpecialty(@PathVariable long id) {
        specialtyService.deleteSpecialtyById(id);
    }

}