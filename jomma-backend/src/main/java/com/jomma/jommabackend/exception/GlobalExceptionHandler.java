package com.jomma.jommabackend.exception;

import com.jomma.jommabackend.entity.Response;
import com.jomma.jommabackend.utils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({Exception.class, JommaException.class})
    public ResponseEntity<Response> handleException(Exception ex) {
        return ResponseEntity.ofNullable(ResponseBuilder.getFailResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
    }
}
