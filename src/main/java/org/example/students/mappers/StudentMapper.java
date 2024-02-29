package org.example.students.mappers;


import org.example.students.dtos.StudentDTO;
import org.example.students.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student StudentDTOToStudent(StudentDTO studentDTO);

    @Mapping(target = "groupNumber", source = "group.groupNumber")
    StudentDTO StudentToStudentDTO(Student student);

}
