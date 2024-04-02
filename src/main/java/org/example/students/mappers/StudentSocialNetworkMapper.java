package org.example.students.mappers;


import org.example.students.dtos.StudentSocialNetworkDTO;
import org.example.students.entities.StudentSocialNetwork;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface StudentSocialNetworkMapper {

    @Mapping(source = "socialNetworkId", target = "socialNetwork.id")
    @Mapping(source = "studentId", target = "student.id")
    StudentSocialNetwork toStudentSocialNetwork(StudentSocialNetworkDTO socialNetworkDTO);

    @Mapping(source = "socialNetwork.id", target = "socialNetworkId")
    @Mapping(source = "student.id", target = "studentId")
    StudentSocialNetworkDTO toStudentSocialNetworkDTO(StudentSocialNetwork socialNetwork);

}