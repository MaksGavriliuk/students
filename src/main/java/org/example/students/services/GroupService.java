package org.example.students.services;

import org.example.students.dtos.GroupDTO;
import org.example.students.dtos.StudentDTO;
import org.example.students.entities.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface GroupService {

    Page<GroupDTO> findGroups(Pageable pageable);

    Group findGroupById(long id);

    GroupDTO getGroupById(long id);

    void deleteGroupById(long id);

    GroupDTO saveGroup(GroupDTO studentDTO);

    GroupDTO updateGroup(long id, GroupDTO specialtyDTO);

    Page<StudentDTO> getStudentsByGroupNumber(String groupNumber, Pageable pageable);
    
}