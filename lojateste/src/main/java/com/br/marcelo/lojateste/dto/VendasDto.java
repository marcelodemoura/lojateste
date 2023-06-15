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

    private String tPdoces;
    private String qtde;
    private String qTotal;
    private String cliente;
    private String fPagamento;
    private String dtCompra;
    private String dtPagamento;
    private String vPago;
    private String Pago;


    public VendasDto(Vendas entity) {
        this.tPdoces = entity.getTPdoces();
        this.qtde = entity.getQtde();
        this.qTotal = entity.getQTotal();
        this.cliente = entity.getCliente();
        this.fPagamento = entity.getFPagamento();
//        this.dtCompra = entity.getDtCompra();
//        this.dtPagamento = entity.getDtPagamento();
        this.vPago = entity.getVPago();
        this.Pago = entity.getPago();
    }
}
