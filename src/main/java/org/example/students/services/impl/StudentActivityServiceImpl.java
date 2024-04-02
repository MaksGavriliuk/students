package org.example.students.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.students.dtos.StudentActivityDTO;
import org.example.students.entities.StudentActivity;
import org.example.students.exceptions.NotFoundException;
import org.example.students.mappers.StudentActivityMapper;
import org.example.students.repositories.StudentActivityRepository;
import org.example.students.services.StudentActivityService;
import org.example.students.services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StudentActivityServiceImpl implements StudentActivityService {

    private final StudentActivityRepository studentActivityRepository;
    private final StudentActivityMapper studentActivityMapper;
    private final StudentService studentService;


    @Override
    public Page<StudentActivityDTO> findStudentActivities(Pageable pageable) {
        return studentActivityRepository.findAll(pageable)
                .map(studentActivityMapper::toStudentActivityDTO);
    }

    @Override
    public StudentActivity findStudentActivityById(long id) {
        return studentActivityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не удалось найти активность с id = " + id));
    }

    @Override
    public StudentActivityDTO getStudentActivityById(long id) {
        return studentActivityMapper.toStudentActivityDTO(findStudentActivityById(id));
    }

    @Override
    public void deleteStudentActivityById(long id) {
        studentActivityRepository.deleteById(id);
    }

    @Override
    public StudentActivityDTO saveStudentActivity(StudentActivityDTO studentActivityDTO) {
        studentService.findStudentById(studentActivityDTO.studentId());
        StudentActivity savedStudentActivity = studentActivityRepository.save(studentActivityMapper.toStudentActivity(studentActivityDTO));
        return studentActivityMapper.toStudentActivityDTO(savedStudentActivity);
    }

    @Override
    public StudentActivityDTO updateStudentActivity(long id, StudentActivityDTO studentActivityDTO) {
        studentService.findStudentById(studentActivityDTO.studentId());
        StudentActivity studentActivity = studentActivityMapper
                .toStudentActivity(studentActivityDTO)
                .setId(findStudentActivityById(id).getId());
        StudentActivity savedStudentActivity = studentActivityRepository.save(studentActivity);
        return studentActivityMapper.toStudentActivityDTO(savedStudentActivity);
    }

    @Override
    public Page<StudentActivityDTO> findStudentActivitiesByStudentId(long studentId) {
        return studentActivityRepository.findStudentActivitiesByStudentId(studentId)
                .map(studentActivityMapper::toStudentActivityDTO);
    }

}