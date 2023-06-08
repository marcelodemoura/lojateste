package com.br.marcelo.lojateste.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Tipodedoce{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Descricao", unique = true, nullable = false, length = 60)
    private String descricao;
    @Column(name = "V_unitario", length = 5, nullable = false)
    private float v_unitario;
    @Column(name = "Qtde_estoque",nullable = false,length = 3)
    private int qtd_estoque;
}
