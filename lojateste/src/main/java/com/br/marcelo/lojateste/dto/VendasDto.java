package com.br.marcelo.lojateste.dto;

import com.br.marcelo.lojateste.entity.Vendas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendasDto {

    private String tpDoce;
    private String quantidade;
    private float vTotal;
    private String cliente;
    private String fPagamento;
    private String dtCompra;
    private String vPago;

    public VendasDto(Vendas entity) {
        this.tpDoce = entity.getTpdoce();
        this.quantidade = String.valueOf(entity.getQuantidade());
        this.vTotal = entity.getVTotal();
        this.cliente = entity.getCliente();
        this.fPagamento = entity.getFPagamento();
        this.dtCompra = entity.getDtCompra();
        this.vPago = entity.getVPago();
    }
}

