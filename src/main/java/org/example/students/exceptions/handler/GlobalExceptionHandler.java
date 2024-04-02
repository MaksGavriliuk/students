package org.example.students.exceptions.handler;

import org.example.students.exceptions.ErrorResponse;
import org.example.students.exceptions.MappingException;
import org.example.students.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleNotFoundException(NotFoundException exception) {
        return new ErrorResponse("NOT_FOUND", exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MappingException.class)
    public ErrorResponse handleMappingException(MappingException exception) {
        return new ErrorResponse("MAPPING_ERROR", exception.getMessage());
    }

}