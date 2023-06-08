package com.br.marcelo.lojateste.dto;


import com.br.marcelo.lojateste.entity.Empresa;

public class EmpresaDto {
    private String nome;
    private String ativa;


    public EmpresaDto(Empresa entity) {
        this.nome = entity.getNome();
        this.ativa = entity.getAtiva();

    }
}
