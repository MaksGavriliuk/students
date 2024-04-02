package org.example.students.repositories;

import io.micrometer.observation.ObservationFilter;
import org.example.students.entities.StudentActivity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentActivityRepository extends JpaRepository<StudentActivity, Long> {
    Page<StudentActivity> findStudentActivitiesByStudentId(long studentId);
}