package com.br.marcelo.lojateste.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_doces")
public class Produto extends Cadastro{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Descricao", nullable = false, unique = true, length = 50)
    private String descricao;
    @Column(name = "V_unit",nullable = false, length = 5)
    private String valorUnitario;
    @Column(name = "Qtde", nullable = false, length = 3)
    private String qtdeEstoque;
}
