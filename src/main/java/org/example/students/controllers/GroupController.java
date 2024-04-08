package org.example.students.controllers;


import lombok.RequiredArgsConstructor;
import org.example.students.dtos.GroupDTO;
import org.example.students.dtos.StudentDTO;
import org.example.students.services.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<GroupDTO> getGroups(Pageable pageable) {
        return groupService.findGroups(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GroupDTO getGroupById(@PathVariable long id) {
        return groupService.getGroupById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GroupDTO createGroup(@RequestBody GroupDTO groupDTO) {
        return groupService.saveGroup(groupDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GroupDTO updateGroup(
            @PathVariable long id,
            @RequestBody GroupDTO groupDTO
    ) {
        return groupService.updateGroup(id, groupDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGroup(@PathVariable long id) {
        groupService.deleteGroupById(id);
    }

    @GetMapping("/{groupNumber}/students")
    @ResponseStatus(HttpStatus.OK)
    public Page<StudentDTO> getStudentsByGroupNumber(@PathVariable String groupNumber, Pageable pageable) {
        return groupService.getStudentsByGroupNumber(groupNumber, pageable);
    }

}