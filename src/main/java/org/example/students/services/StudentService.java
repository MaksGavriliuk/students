package org.example.students.services;


import org.example.students.dtos.StudentDTO;
import org.example.students.dtos.StudentSocialNetworkDTO;
import org.example.students.entities.Photo;
import org.example.students.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface StudentService {

    boolean existsByStudentId(long studentId);

    Page<StudentDTO> findStudents(Pageable pageable);

    Student findStudentById(long id);

    StudentDTO getStudentById(long id);

    void deleteStudentById(long id);

    StudentDTO saveStudent(StudentDTO studentDTO, MultipartFile photo);

    StudentDTO updateStudent(long id, StudentDTO studentDTO, MultipartFile photo);

    Photo getPhotoByStudentId(long studentId);

    void updatePhotoByStudentId(Long id, MultipartFile photo);

    List<StudentSocialNetworkDTO> getStudentSocialNetworksByStudentId(long studentId);

}