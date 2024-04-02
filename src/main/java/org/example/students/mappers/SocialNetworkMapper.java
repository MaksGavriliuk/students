package org.example.students.mappers;


import org.example.students.dtos.SocialNetworkDTO;
import org.example.students.entities.SocialNetwork;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface SocialNetworkMapper {

    @Mapping(target = "studentSocialNetworks", ignore = true)
    SocialNetwork toSocialNetwork(SocialNetworkDTO socialNetworkDTO);

    SocialNetworkDTO toSocialNetworkDTO(SocialNetwork socialNetwork);

}