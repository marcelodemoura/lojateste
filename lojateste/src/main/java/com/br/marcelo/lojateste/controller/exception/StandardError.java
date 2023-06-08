package com.br.marcelo.lojateste.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
@AllArgsConstructor
@Getter
@Setter
public class StandardError extends RuntimeException{


    private Instant timeStamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public StandardError(){

    }
}
