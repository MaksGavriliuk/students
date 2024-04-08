package org.example.students.controllers;

import lombok.RequiredArgsConstructor;
import org.example.students.dtos.StudentDTO;
import org.example.students.entities.Photo;
import org.example.students.services.StudentService;
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
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<StudentDTO> getStudents(Pageable pageable) {
        return studentService.findStudents(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDTO getStudentById(@PathVariable long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO createStudent(StudentDTO studentDTO, MultipartFile photo) {
        return studentService.saveStudent(studentDTO, photo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDTO updateStudent(
            @PathVariable long id,
            StudentDTO studentDTO,
            MultipartFile photo
    ) {
        return studentService.updateStudent(id, studentDTO, photo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudentById(id);
    }

    @GetMapping("/exists/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean existsByStudentId(@PathVariable long id) {
        return studentService.existsByStudentId(id);
    }

    @GetMapping("/{id}/photo")
    @ResponseStatus(HttpStatus.OK)
    public Photo getPhotoByStudentId(@PathVariable long id) {
        return studentService.getPhotoByStudentId(id);
    }

    @PutMapping("/{id}/photo")
    @ResponseStatus(HttpStatus.OK)
    public void updatePhotoByCandidateId(@PathVariable long id, MultipartFile photo) {
        studentService.updatePhotoByCandidateId(id, photo);
    }

}