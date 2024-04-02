package org.example.students.mappers;


import org.example.students.dtos.StudentActivityDTO;
import org.example.students.entities.StudentActivity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface StudentActivityMapper {

    @Mapping(source = "studentId", target = "student.id")
    StudentActivity toStudentActivity(StudentActivityDTO studentActivityDTO);

    @Mapping(source = "student.id", target = "studentId")
    StudentActivityDTO toStudentActivityDTO(StudentActivity studentActivity);
    
}