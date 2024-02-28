package org.example.students.repositories;

import org.example.students.entities.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
