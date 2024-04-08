package org.example.students.controllers;


import lombok.RequiredArgsConstructor;
import org.example.students.dtos.SocialNetworkDTO;
import org.example.students.services.SocialNetworkService;
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
@RequestMapping("/social-networks")
@RequiredArgsConstructor
public class SocialNetworkController {

    private final SocialNetworkService socialNetworkService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<SocialNetworkDTO> getSocialNetworks(Pageable pageable) {
        return socialNetworkService.findSocialNetworks(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SocialNetworkDTO getSocialNetworkById(@PathVariable long id) {
        return socialNetworkService.getSocialNetworkById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SocialNetworkDTO createSocialNetwork(@RequestBody SocialNetworkDTO socialNetworkDTO) {
        return socialNetworkService.saveSocialNetwork(socialNetworkDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SocialNetworkDTO updateSocialNetwork(
            @PathVariable long id,
            @RequestBody SocialNetworkDTO socialNetworkDTO
    ) {
        return socialNetworkService.updateSocialNetwork(id, socialNetworkDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSocialNetwork(@PathVariable long id) {
        socialNetworkService.deleteSocialNetworkById(id);
    }

}