package com.example.softwarearchitecture.controller;

import com.example.softwarearchitecture.exception.XException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(XException.class)
    public Map<String, Object> handleException(XException e) {
        return Map.of("message",e.getMessage());
    }

}
