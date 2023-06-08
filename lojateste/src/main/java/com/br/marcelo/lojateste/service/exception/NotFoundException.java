package com.br.marcelo.lojateste.service.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String description){
        super(description);
    }
}
