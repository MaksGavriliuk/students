package org.example.students.repositories;

import org.example.students.entities.StudentActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentActivityRepository extends JpaRepository<StudentActivity, Long> {
}