package com.example.orderapiexample.controller;

import com.example.orderapiexample.exception.BaseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseControllerAdvice {


    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> onBaseExceptionHandled(BaseException baseException)
    {
        return ResponseEntity.badRequest().body(new ApiError(baseException.getMessage()));
    }


    public static record ApiError(String errorMessage)
    {
    }
}
