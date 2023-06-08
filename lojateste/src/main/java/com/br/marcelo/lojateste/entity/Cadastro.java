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

    @JsonFormat(pattern = "dd/mm;yyyy")
    LocalDateTime datacadastro;
    @JsonFormat(pattern = "dd/mm;yyyy")
    LocalDateTime dataAtualizacao;

}
