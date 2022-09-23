package com.integrador.odonto.backendquintobimestre.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(VariableNullException.class)
    public ResponseEntity<ResponseException> handlerVariableNullException(VariableNullException exception) {
        ResponseException responseException = new ResponseException(HttpStatus.NOT_ACCEPTABLE.value(),
                exception.getMessage(), LocalDateTime.now(), exception.getListVariable());
        return new ResponseEntity<>(responseException, HttpStatus.NOT_ACCEPTABLE);
    }
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseException> handlerNotFoundException(NotFoundException exception) {
        ResponseException responseException = new ResponseException(HttpStatus.NOT_FOUND.value(),
                exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(responseException, HttpStatus.NOT_FOUND);
    }
}
