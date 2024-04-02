package org.example.students.repositories;


import org.example.students.dtos.StudentSocialNetworkDTO;
import org.example.students.entities.StudentSocialNetwork;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentSocialNetworkRepository extends JpaRepository<StudentSocialNetwork, Long> {
    Page<StudentSocialNetworkDTO> findStudentSocialNetworksByStudentId(long studentId);
}