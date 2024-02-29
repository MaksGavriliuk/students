package org.example.students.services.impl;


import lombok.AllArgsConstructor;
import org.example.students.dtos.StudentDTO;
import org.example.students.entities.Student;
import org.example.students.mappers.StudentMapper;
import org.example.students.repositories.StudentRepository;
import org.example.students.services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.example.students.exceptions.NotFoundException;

import java.util.List;


@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public boolean existsByStudentId(long studentId) {
        return studentRepository.existsById(studentId);
    }

    @Override
    public Page<Student> findStudents(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student findStudentById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student findStudentByIdOrElseThrow(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не удалось найти студента с id = " + id));
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student saveStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.INSTANCE.StudentDTOToStudent(studentDTO);
        return studentRepository.save(student);
    }

    @Override
    public List<Student> saveStudents(List<StudentDTO> studentsDTO) {
        List<Student> students = studentsDTO
                .stream()
                .map(StudentMapper.INSTANCE::StudentDTOToStudent)
                .toList();
        return studentRepository.saveAll(students);
    }

    @Override
    public Student updateStudent(long id, StudentDTO studentDTO) {
        Student student = StudentMapper.INSTANCE
                .StudentDTOToStudent(studentDTO)
                .setId(findStudentByIdOrElseThrow(id).getId());
        return studentRepository.save(student);
    }

}
