package org.example.students.repositories;

import org.example.students.entities.ScientificPublication;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScientificPublicationRepository extends JpaRepository<ScientificPublication, Long> {
    Page<ScientificPublication> findScientificPublicationsByStudentId(long studentId);
}