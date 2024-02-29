package org.example.students.services;


import org.example.students.dtos.StudentDTO;
import org.example.students.entities.Student;
import org.springframework.data.domain.Page;

import java.util.List;


public interface StudentService {

    boolean existsByStudentId(long studentId);

    Page<Student> findStudents(int pageNumber, int pageSize);

    Student findStudentById(long id);

    Student findStudentByIdOrElseThrow(long id);

    void deleteStudentById(long id);

    Student saveStudent(StudentDTO studentDTO);

    List<Student> saveStudents(List<StudentDTO> studentsDTO);

    Student updateStudent(long id, StudentDTO studentDTO);

}
