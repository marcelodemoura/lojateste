package com.br.marcelo.lojateste.dto;

import com.br.marcelo.lojateste.entity.Pagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDto {
    private String descricao;

    public PagamentoDto(Pagamento entity){
        this.descricao = entity.getDescricao();
    }
}
