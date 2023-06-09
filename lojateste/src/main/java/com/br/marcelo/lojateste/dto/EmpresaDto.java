package com.br.marcelo.lojateste.dto;


import com.br.marcelo.lojateste.entity.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDto {
    private String nome;
    private String ativa;

    public EmpresaDto(Empresa entity) {
        this.nome = entity.getNome();
        this.ativa = entity.getAtiva();

    }
}
