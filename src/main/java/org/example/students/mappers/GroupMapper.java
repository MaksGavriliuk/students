package org.example.students.mappers;

import org.example.students.dtos.GroupDTO;
import org.example.students.entities.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface GroupMapper {

    @Mapping(target = "specialization.id", source = "specializationId")
    Group toGroup(GroupDTO groupDTO);

    @Mapping(target = "specializationId", source = "specialization.id")
    GroupDTO toGroupDTO(Group group);

}