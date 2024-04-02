package org.example.students.mappers;

import org.example.students.entities.Photo;
import org.example.students.exceptions.MappingException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface PhotoMapper {

    default Photo toPhoto(MultipartFile multipartFile) throws MappingException {
        try {
            return new Photo()
                    .setName(multipartFile.getOriginalFilename())
                    .setFormat(multipartFile.getContentType())
                    .setPhoto(multipartFile.getBytes());
        } catch (IOException e) {
            throw new MappingException("Ошибка маппинга multipart file в Photo " + e);
        }
    }

}