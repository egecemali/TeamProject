package com.teams.project.core.utilities.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final View error;

    public GlobalExceptionHandler(View error) {
        this.error = error;
    }


    //Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessExeption.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessExeption(BusinessExeption businessExeption) {
        //log.error(businessExeption.getMessage());
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMassage(businessExeption.getMessage());
        problemDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        problemDetails.setTimeStamp(System.currentTimeMillis());
        return problemDetails;
    }
    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        //log.error(exception.getMessage());
        List<String> problemDetailsList = new ArrayList<>();
        ProblemDetails problemDetails = new ProblemDetails();
        exception.getAllErrors().forEach(error -> problemDetailsList.add(error.getDefaultMessage()));
        problemDetails.setMassage(problemDetailsList.toString());
        problemDetails.setTimeStamp(System.currentTimeMillis());
        problemDetails.setStatus(HttpStatus.BAD_REQUEST.value());

        return problemDetails;
    }*/
    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)

    public ProblemDetails handleAlreadyExistException(AlreadyExistException exception) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMassage(exception.getMessage());
        problemDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        problemDetails.setTimeStamp(System.currentTimeMillis());
        return problemDetails;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

}
