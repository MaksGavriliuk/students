package org.example.students.controllers;


import lombok.RequiredArgsConstructor;
import org.example.students.dtos.StudentSocialNetworkDTO;
import org.example.students.services.StudentSocialNetworkService;
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
@RequestMapping("/student-social-networks")
@RequiredArgsConstructor
public class StudentSocialNetworkController {

    private final StudentSocialNetworkService studentSocialNetworkService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<StudentSocialNetworkDTO> getStudentSocialNetworks(Pageable pageable) {
        return studentSocialNetworkService.findStudentSocialNetworks(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentSocialNetworkDTO getStudentSocialNetworkById(@PathVariable long id) {
        return studentSocialNetworkService.getStudentSocialNetworkById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentSocialNetworkDTO createStudentSocialNetwork(@RequestBody StudentSocialNetworkDTO studentSocialNetworkDTO) {
        return studentSocialNetworkService.saveStudentSocialNetwork(studentSocialNetworkDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentSocialNetworkDTO updateStudentSocialNetwork(
            @PathVariable long id,
            @RequestBody StudentSocialNetworkDTO studentSocialNetworkDTO
    ) {
        return studentSocialNetworkService.updateStudentSocialNetwork(id, studentSocialNetworkDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentSocialNetwork(@PathVariable long id) {
        studentSocialNetworkService.deleteStudentSocialNetworkById(id);
    }

    @GetMapping("/student/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public Page<StudentSocialNetworkDTO> findStudentSocialNetworksByStudentId(@PathVariable long studentId, Pageable pageable) {
        return studentSocialNetworkService.findStudentSocialNetworksByStudentId(studentId, pageable);
    }

}