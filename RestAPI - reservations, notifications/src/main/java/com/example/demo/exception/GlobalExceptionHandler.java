package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Map<String,Object>> BookNotFoundExceptionAdvice (BookNotFoundException  e){
        Map<String,Object> response = new HashMap<>();

        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
        response.put("message", e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<Map<String,Object>> InvalidRequestExceptionAdvice (InvalidRequestException e){
        Map<String,Object> response = new HashMap<>();

        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.put("message", e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> GenericExceptionAdvice (Exception e){
        Map<String,Object> response = new HashMap<>();

        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.put("error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response.put("message", e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
