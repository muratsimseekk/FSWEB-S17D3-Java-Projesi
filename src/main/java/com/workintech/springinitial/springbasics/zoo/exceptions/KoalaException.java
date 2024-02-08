package com.workintech.springinitial.springbasics.zoo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class KoalaException extends RuntimeException{

    private HttpStatus status;

    public KoalaException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
