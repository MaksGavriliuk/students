package org.example.students.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.students.dtos.GroupDTO;
import org.example.students.dtos.StudentDTO;
import org.example.students.entities.Group;
import org.example.students.exceptions.NotFoundException;
import org.example.students.mappers.GroupMapper;
import org.example.students.repositories.GroupRepository;
import org.example.students.services.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;


    @Override
    public Page<GroupDTO> findGroups(Pageable pageable) {
        return groupRepository.findAll(pageable)
                .map(groupMapper::toGroupDTO);
    }

    @Override
    public Group findGroupById(long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не удалось найти группу с id = " + id));
    }

    @Override
    public GroupDTO getGroupById(long id) {
        return groupMapper.toGroupDTO(findGroupById(id));
    }

    @Override
    public void deleteGroupById(long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public GroupDTO saveGroup(GroupDTO studentDTO) {
        Group savedGroup = groupRepository.save(groupMapper.toGroup(studentDTO));
        return groupMapper.toGroupDTO(savedGroup);
    }

    @Override
    public GroupDTO updateGroup(long id, GroupDTO groupDTO) {
        Group group = groupMapper
                .toGroup(groupDTO)
                .setId(findGroupById(id).getId());
        Group savedGroup = groupRepository.save(group);
        return groupMapper.toGroupDTO(savedGroup);
    }

    @Override
    public Page<StudentDTO> getStudentsByGroupNumber(String groupNumber, Pageable pageable) {
        return groupRepository.findStudentsByGroupNumber(groupNumber, pageable);
    }
}
