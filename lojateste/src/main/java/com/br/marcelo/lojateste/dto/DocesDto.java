package com.br.marcelo.lojateste.dto;

import com.br.marcelo.lojateste.entity.Doces;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DocesDto {
    private String descricao;
    private String valorUnitario;
    private String qtdeEstoque;

    public DocesDto(Doces entity) {
        this.descricao = entity.getDescricao();
        this.qtdeEstoque = entity.getValorUnitario();
        this.valorUnitario = entity.getQtdeEstoque();


    }
}
