package com.br.marcelo.lojateste.dto;

import com.br.marcelo.lojateste.entity.Tdoce;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TDoceDto {
    private String descriao;
    private float v_unitario;
    private String qtd_estoque;

    public TDoceDto(Tdoce entity){
        this.descriao = entity.getDescricao();
        this.v_unitario = entity.getV_unitario();
    }

}
