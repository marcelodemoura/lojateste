package com.br.marcelo.lojateste.dto;

import com.br.marcelo.lojateste.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProdutoDto {
    private String descricao;
    private String valorUnitario;
    private String qtdeEstoque;

    public ProdutoDto(Produto entity) {
        this.descricao = entity.getDescricao();
        this.qtdeEstoque = entity.getValorUnitario();
        this.valorUnitario = entity.getQtdeEstoque();


    }
}
