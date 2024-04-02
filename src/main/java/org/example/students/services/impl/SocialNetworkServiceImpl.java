package org.example.students.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.students.dtos.SocialNetworkDTO;
import org.example.students.entities.SocialNetwork;
import org.example.students.exceptions.NotFoundException;
import org.example.students.mappers.SocialNetworkMapper;
import org.example.students.repositories.SocialNetworkRepository;
import org.example.students.services.SocialNetworkService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SocialNetworkServiceImpl implements SocialNetworkService {

    private final SocialNetworkRepository socialNetworkRepository;
    private final SocialNetworkMapper socialNetworkMapper;


    @Override
    public Page<SocialNetworkDTO> findSocialNetworks(Pageable pageable) {
        return socialNetworkRepository.findAll(pageable)
                .map(socialNetworkMapper::toSocialNetworkDTO);
    }

    @Override
    public SocialNetwork findSocialNetworkById(long id) {
        return socialNetworkRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не удалось найти социальную сеть с id = " + id));
    }

    @Override
    public SocialNetworkDTO getSocialNetworkById(long id) {
        return socialNetworkMapper.toSocialNetworkDTO(findSocialNetworkById(id));
    }

    @Override
    public void deleteSocialNetworkById(long id) {
        socialNetworkRepository.deleteById(id);
    }

    @Override
    public SocialNetworkDTO saveSocialNetwork(SocialNetworkDTO studentDTO) {
        SocialNetwork savedSocialNetwork = socialNetworkRepository.save(socialNetworkMapper.toSocialNetwork(studentDTO));
        return socialNetworkMapper.toSocialNetworkDTO(savedSocialNetwork);
    }

    @Override
    public SocialNetworkDTO updateSocialNetwork(long id, SocialNetworkDTO socialNetworkDTO) {
        SocialNetwork socialNetwork = socialNetworkMapper
                .toSocialNetwork(socialNetworkDTO)
                .setId(findSocialNetworkById(id).getId());
        SocialNetwork savedSocialNetwork = socialNetworkRepository.save(socialNetwork);
        return socialNetworkMapper.toSocialNetworkDTO(savedSocialNetwork);
    }

}