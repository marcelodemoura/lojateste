package com.br.marcelo.lojateste.dto;

import com.br.marcelo.lojateste.entity.FPagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FPagamentoDto {

    private String descricao;

    public FPagamentoDto(FPagamento entity) {
        this.descricao = entity.getDescricao();
    }


}
