package com.br.marcelo.lojateste.service.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String description){
        super(description);
    }
}
