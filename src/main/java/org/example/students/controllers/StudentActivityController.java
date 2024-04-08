package org.example.students.controllers;

import lombok.RequiredArgsConstructor;
import org.example.students.dtos.StudentActivityDTO;
import org.example.students.services.StudentActivityService;
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
@RequestMapping("/student-activities")
@RequiredArgsConstructor
public class StudentActivityController {

    private final StudentActivityService studentActivityService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<StudentActivityDTO> getStudentActivities(Pageable pageable) {
        return studentActivityService.findStudentActivities(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentActivityDTO getStudentActivityById(@PathVariable long id) {
        return studentActivityService.getStudentActivityById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentActivityDTO createStudentActivity(@RequestBody StudentActivityDTO studentActivityDTO) {
        return studentActivityService.saveStudentActivity(studentActivityDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentActivityDTO updateStudentActivity(
            @PathVariable long id,
            @RequestBody StudentActivityDTO studentActivityDTO
    ) {
        return studentActivityService.updateStudentActivity(id, studentActivityDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentActivity(@PathVariable long id) {
        studentActivityService.deleteStudentActivityById(id);
    }

    @GetMapping("/student/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    Page<StudentActivityDTO> findStudentActivitiesByStudentId(@PathVariable long studentId, Pageable pageable){
        return studentActivityService.findStudentActivitiesByStudentId(studentId, pageable);
    }

}