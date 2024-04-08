package org.example.students.mappers;

import org.example.students.dtos.StudentDTO;
import org.example.students.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Mapping(target = "groupId", source = "student.group.id")
    StudentDTO toStudentDTO(Student student);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "group.id", source = "groupId")
    Student toStudent(StudentDTO studentDTO);

    List<StudentDTO> toDTOList(List<Student> students);

    List<Student> toEntityList(List<StudentDTO> studentDTOs);

}