package com.br.marcelo.lojateste.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "/vendas")
public class Vendas extends Cadastro{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TP_Doces",nullable = false, length = 5)
    private String tPdoces;
    @Column(name = "Qtde",nullable = false, length = 5)
    private String qtde;
    @Column(name = "QTotal",nullable = false, length = 5)
    private String qTotal;
    @Column(name = "Cliente",nullable = false, length = 30)
    private String cliente;
    @Column(name = "FPagamento",nullable = false, length = 10)
    private String fPagamento;
    @Column(name = "DTCompra",nullable = false, length = 5)
    private String dtCompra;
    @Column(name = "DTPagamento",nullable = false, length = 5)
    private String dtPagamento;
    @Column(name = "VPago",nullable = false, length = 5)
    private String vPago;
    @Column(name = "Pago",nullable = false, length = 5)
    private String Pago;

}
