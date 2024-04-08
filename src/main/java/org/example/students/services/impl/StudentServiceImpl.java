package org.example.students.services.impl;


import lombok.RequiredArgsConstructor;
import org.example.students.dtos.StudentDTO;
import org.example.students.dtos.StudentSocialNetworkDTO;
import org.example.students.entities.Photo;
import org.example.students.entities.Student;
import org.example.students.mappers.PhotoMapper;
import org.example.students.mappers.StudentMapper;
import org.example.students.mappers.StudentSocialNetworkMapper;
import org.example.students.repositories.PhotoRepository;
import org.example.students.repositories.StudentRepository;
import org.example.students.services.GroupService;
import org.example.students.services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.example.students.exceptions.NotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final StudentSocialNetworkMapper studentSocialNetworkMapper;
    private final PhotoRepository photoRepository;
    private final PhotoMapper photoMapper;
    private final GroupService groupService;


    @Override
    public boolean existsByStudentId(long studentId) {
        return studentRepository.existsById(studentId);
    }

    @Override
    public Page<StudentDTO> findStudents(Pageable pageable) {
        return studentRepository.findAll(pageable)
                .map(studentMapper::toStudentDTO);
    }

    @Override
    public Student findStudentById(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не удалось найти студента с id = " + id));
    }

    @Override
    public StudentDTO getStudentById(long id) {
        return studentMapper.toStudentDTO(findStudentById(id));
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO, MultipartFile photo) {
        groupService.findGroupById(studentDTO.groupId());
        Photo mappedPhoto = photoMapper.toPhoto(photo);
        Photo savedPhoto = photoRepository.save(mappedPhoto);
        Student student = studentMapper.toStudent(studentDTO)
                .setPhoto(savedPhoto);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toStudentDTO(savedStudent);
    }

    @Override
    public StudentDTO updateStudent(long id, StudentDTO studentDTO, MultipartFile photo) {
        groupService.findGroupById(studentDTO.groupId());
        Photo mappedPhoto = photoMapper.toPhoto(photo);
        Photo savedPhoto = photoRepository.save(mappedPhoto);
        Student student = studentMapper.toStudent(studentDTO)
                .setPhoto(savedPhoto)
                .setId(id);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toStudentDTO(savedStudent);
    }

    @Override
    public Photo getPhotoByStudentId(long studentId) {
        return findStudentById(studentId).getPhoto();
    }

    @Override
    @Transactional
    public void updatePhotoByStudentId(Long id, MultipartFile photo) {
        Student student = findStudentById(id);
        long photoId = student.getPhoto().getId();
        photoRepository.deleteById(photoId);
        Photo mappedPhoto = photoMapper.toPhoto(photo);
        Photo savedPhoto = photoRepository.save(mappedPhoto);
        student.setPhoto(savedPhoto);
        studentRepository.save(student);
    }

    @Override
    public List<StudentSocialNetworkDTO> getStudentSocialNetworksByStudentId(long studentId) {
        return findStudentById(studentId).getSocialNetworks()
                .stream()
                .map(studentSocialNetworkMapper::toStudentSocialNetworkDTO)
                .toList();
    }

}