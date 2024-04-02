package org.example.students.repositories;

import org.example.students.dtos.StudentDTO;
import org.example.students.entities.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Page<StudentDTO> findStudentsByGroupNumber(String groupNumber, Pageable pageable);
}