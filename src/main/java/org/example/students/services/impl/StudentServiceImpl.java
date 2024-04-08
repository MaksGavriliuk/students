package org.example.students.services.impl;


import lombok.RequiredArgsConstructor;
import org.example.students.dtos.StudentDTO;
import org.example.students.entities.Photo;
import org.example.students.entities.Student;
import org.example.students.mappers.PhotoMapper;
import org.example.students.mappers.StudentMapper;
import org.example.students.repositories.PhotoRepository;
import org.example.students.repositories.StudentRepository;
import org.example.students.services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.example.students.exceptions.NotFoundException;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final PhotoRepository photoRepository;
    private final PhotoMapper photoMapper;


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
        Photo mappedPhoto = photoMapper.toPhoto(photo);
        Photo savedPhoto = photoRepository.save(mappedPhoto);
        Student student = studentMapper.toStudent(studentDTO)
                .setPhoto(savedPhoto);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toStudentDTO(savedStudent);
    }

    @Override
    public StudentDTO updateStudent(long id, StudentDTO studentDTO, MultipartFile photo) {
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
    public void updatePhotoByCandidateId(Long id, MultipartFile photo) {

    }

}