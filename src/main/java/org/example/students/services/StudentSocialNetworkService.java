package org.example.students.services;

import org.example.students.dtos.StudentSocialNetworkDTO;
import org.example.students.entities.StudentSocialNetwork;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface StudentSocialNetworkService {

    Page<StudentSocialNetworkDTO> findStudentSocialNetworks(Pageable pageable);

    StudentSocialNetwork findStudentSocialNetworkById(long id);

    StudentSocialNetworkDTO getStudentSocialNetworkById(long id);

    void deleteStudentSocialNetworkById(long id);

    StudentSocialNetworkDTO saveStudentSocialNetwork(StudentSocialNetworkDTO studentDTO);

    StudentSocialNetworkDTO updateStudentSocialNetwork(long id, StudentSocialNetworkDTO specialtyDTO);

    Page<StudentSocialNetworkDTO> findStudentSocialNetworksByStudentId(long studentId, Pageable pageable);
    
}