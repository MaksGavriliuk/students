package org.example.students.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.students.dtos.StudentSocialNetworkDTO;
import org.example.students.dtos.StudentSocialNetworkDTO;
import org.example.students.dtos.StudentSocialNetworkDTO;
import org.example.students.entities.StudentSocialNetwork;
import org.example.students.entities.StudentSocialNetwork;
import org.example.students.entities.StudentSocialNetwork;
import org.example.students.exceptions.NotFoundException;
import org.example.students.mappers.StudentSocialNetworkMapper;
import org.example.students.repositories.StudentSocialNetworkRepository;
import org.example.students.services.SocialNetworkService;
import org.example.students.services.StudentService;
import org.example.students.services.StudentSocialNetworkService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StudentSocialNetworkServiceImpl implements StudentSocialNetworkService {

    private final StudentSocialNetworkRepository studentSocialNetworkRepository;
    private final StudentSocialNetworkMapper studentSocialNetworkMapper;
    private final SocialNetworkService socialNetworkService;
    private final StudentService studentService;


    @Override
    public Page<StudentSocialNetworkDTO> findStudentSocialNetworks(Pageable pageable) {
        return studentSocialNetworkRepository.findAll(pageable)
                .map(studentSocialNetworkMapper::toStudentSocialNetworkDTO);
    }

    @Override
    public StudentSocialNetwork findStudentSocialNetworkById(long id) {
        return studentSocialNetworkRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не удалось найти социальную связь студента с id = " + id));
    }

    @Override
    public StudentSocialNetworkDTO getStudentSocialNetworkById(long id) {
        return studentSocialNetworkMapper.toStudentSocialNetworkDTO(findStudentSocialNetworkById(id));
    }

    @Override
    public void deleteStudentSocialNetworkById(long id) {
        studentSocialNetworkRepository.deleteById(id);
    }

    @Override
    public StudentSocialNetworkDTO saveStudentSocialNetwork(StudentSocialNetworkDTO studentSocialNetworkDTO) {
        studentService.findStudentById(studentSocialNetworkDTO.studentId());
        socialNetworkService.findSocialNetworkById(studentSocialNetworkDTO.socialNetworkId());
        StudentSocialNetwork savedStudentSocialNetwork = studentSocialNetworkRepository.save(studentSocialNetworkMapper.toStudentSocialNetwork(studentSocialNetworkDTO));
        return studentSocialNetworkMapper.toStudentSocialNetworkDTO(savedStudentSocialNetwork);
    }

    @Override
    public StudentSocialNetworkDTO updateStudentSocialNetwork(long id, StudentSocialNetworkDTO studentSocialNetworkDTO) {
        studentService.findStudentById(studentSocialNetworkDTO.studentId());
        socialNetworkService.findSocialNetworkById(studentSocialNetworkDTO.socialNetworkId());
        StudentSocialNetwork studentSocialNetwork = studentSocialNetworkMapper
                .toStudentSocialNetwork(studentSocialNetworkDTO)
                .setId(findStudentSocialNetworkById(id).getId());
        StudentSocialNetwork savedStudentSocialNetwork = studentSocialNetworkRepository.save(studentSocialNetwork);
        return studentSocialNetworkMapper.toStudentSocialNetworkDTO(savedStudentSocialNetwork);
    }


    @Override
    public Page<StudentSocialNetworkDTO> findStudentSocialNetworksByStudentId(long studentId) {
        return studentSocialNetworkRepository.findStudentSocialNetworksByStudentId(studentId);
    }

}