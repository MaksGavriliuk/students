package org.example.students.services;


import org.example.students.dtos.StudentActivityDTO;
import org.example.students.entities.StudentActivity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface StudentActivityService {

    Page<StudentActivityDTO> findStudentActivities(Pageable pageable);

    StudentActivity findStudentActivityById(long id);

    StudentActivityDTO getStudentActivityById(long id);

    void deleteStudentActivityById(long id);

    StudentActivityDTO saveStudentActivity(StudentActivityDTO studentDTO);

    StudentActivityDTO updateStudentActivity(long id, StudentActivityDTO specialtyDTO);

    Page<StudentActivityDTO> findStudentActivitiesByStudentId(long studentId, Pageable pageable);
    
}