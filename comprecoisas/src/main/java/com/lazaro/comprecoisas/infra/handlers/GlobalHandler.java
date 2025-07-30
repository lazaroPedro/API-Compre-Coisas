package com.lazaro.comprecoisas.infra.handlers;

import com.lazaro.comprecoisas.infra.exceptions.NullCategoriaPaiException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Void> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(NullCategoriaPaiException.class)
    public ResponseEntity<String> handleNullCategoriaPaiException(NullCategoriaPaiException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
