package org.ectimel.dietgenerator.infrastructure.configuration;

import org.apache.coyote.BadRequestException;
import org.ectimel.dietgenerator.infrastructure.exceptions.ResourceNotFoundException;
import org.ectimel.dietgenerator.presentation.dto.response.ExceptionResponse;
import org.ectimel.dietgenerator.domain.exception.WrongInputException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleIllegalArgumentException(
            ResourceNotFoundException exception, WebRequest webRequest) {

        ExceptionResponse errorDto = new ExceptionResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            errors.put(((FieldError) error).getField(),
                    error.getDefaultMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

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



    @ExceptionHandler(WrongInputException.class)
    public ResponseEntity<ExceptionResponse> handleWrongInputException(WrongInputException exception, WebRequest webRequest) {

        ExceptionResponse errorDto = new ExceptionResponse(
                exception.getMessage(),
                new Date(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }






}
