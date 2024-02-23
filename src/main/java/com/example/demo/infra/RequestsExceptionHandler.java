package com.example.demo.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class RequestsExceptionHandler {

    //Tratamento de erros do tipo não encontrado
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity thread404(){
        return ResponseEntity.badRequest().body("Dado não encontrado!");
    }

    //Tratamento de erro quando falha a validação
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity notvalid(){
        return ResponseEntity.badRequest().body("Os dados enviados não são validos ou estão faltosos!");
    }
}
