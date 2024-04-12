package org.ectimel.dietgenerator.infrastructure.configuration;

import org.apache.coyote.BadRequestException;
import org.ectimel.dietgenerator.infrastructure.exceptions.ResourceNotFoundException;
import org.ectimel.dietgenerator.presentation.api.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleGlobalException(Exception exception, WebRequest webRequest) {

        ExceptionResponse errorDto = new ExceptionResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handleGlobalException(BadRequestException exception, WebRequest webRequest) {

        ExceptionResponse errorDto = new ExceptionResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> handleIllegalArgumentException(IllegalArgumentException exception, WebRequest webRequest) {

        ExceptionResponse errorDto = new ExceptionResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleIllegalArgumentException(ResourceNotFoundException exception, WebRequest webRequest) {

        ExceptionResponse errorDto = new ExceptionResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }






}
