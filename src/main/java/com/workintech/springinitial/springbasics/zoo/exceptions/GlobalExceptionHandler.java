package com.workintech.springinitial.springbasics.zoo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(KangarooException.class)
    public ResponseEntity<KangarooErrorResponse> handleKangarooException(KangarooException kangarooException){

        KangarooErrorResponse kangarooErrorResponse = new KangarooErrorResponse(kangarooException.getStatus().value(),
                kangarooException.getMessage(), LocalDateTime.now()
                );
        return new ResponseEntity<>(kangarooErrorResponse,kangarooException.getStatus());
    }

    @ExceptionHandler(KoalaException.class)
    public ResponseEntity<KoalaErrorResponse> handleKoalaException(KoalaException koalaException){
        KoalaErrorResponse koalaErrorResponse = new KoalaErrorResponse(koalaException.getStatus().value(), koalaException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(koalaErrorResponse,koalaException.getStatus());
    }



}
