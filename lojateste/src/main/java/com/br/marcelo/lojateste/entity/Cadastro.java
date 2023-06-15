package com.br.marcelo.lojateste.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Cadastro {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy@HH:mm:ss")
    LocalDateTime datacadastro;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy@HH:mm:ss")
    LocalDateTime dataAtualizacao;

}
