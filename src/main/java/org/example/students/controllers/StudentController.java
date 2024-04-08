package org.example.students.controllers;

import lombok.RequiredArgsConstructor;
import org.example.students.dtos.StudentDTO;
import org.example.students.dtos.StudentSocialNetworkDTO;
import org.example.students.entities.Photo;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.example.students.services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;


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
    public ResponseEntity<Resource> getPhotoByStudentId(@PathVariable long id) {
        Photo photo = studentService.getPhotoByStudentId(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + URLEncoder.encode(photo.getName(), StandardCharsets.UTF_8) + "\"")
                .contentLength(photo.getPhoto().length)
                .contentType(MediaType.parseMediaType(photo.getFormat()))
                .body(new ByteArrayResource(photo.getPhoto()));
    }

    @PutMapping("/{id}/photo")
    @ResponseStatus(HttpStatus.OK)
    public void updatePhotoByCandidateId(@PathVariable long id, MultipartFile photo) {
        studentService.updatePhotoByStudentId(id, photo);
    }

    @GetMapping("/{id}/social-networks")
    @ResponseStatus(HttpStatus.OK)
    List<StudentSocialNetworkDTO> getStudentSocialNetworksByStudentId(@PathVariable long id) {
        return studentService.getStudentSocialNetworksByStudentId(id);
    }

}