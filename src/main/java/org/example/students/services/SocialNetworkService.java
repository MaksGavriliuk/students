package org.example.students.services;

import org.example.students.dtos.SocialNetworkDTO;
import org.example.students.entities.SocialNetwork;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface SocialNetworkService {

    Page<SocialNetworkDTO> findSocialNetworks(Pageable pageable);

    SocialNetwork findSocialNetworkById(long id);

    SocialNetworkDTO getSocialNetworkById(long id);

    void deleteSocialNetworkById(long id);

    SocialNetworkDTO saveSocialNetwork(SocialNetworkDTO studentDTO);

    SocialNetworkDTO updateSocialNetwork(long id, SocialNetworkDTO specialtyDTO);
    
}