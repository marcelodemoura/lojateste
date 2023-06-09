package com.br.marcelo.lojateste.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tdoce {
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
