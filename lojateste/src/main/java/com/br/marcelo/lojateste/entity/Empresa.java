package com.br.marcelo.lojateste.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_empresa")
public class Empresa extends Cadastro{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nome", nullable = false, length = 50, unique = true)
    private String nome;
    @Column(name = "Ativa", nullable = false,length = 1)
    private String ativa;
}
