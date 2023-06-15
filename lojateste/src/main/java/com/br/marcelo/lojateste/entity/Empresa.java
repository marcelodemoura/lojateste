package com.br.marcelo.lojateste.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "empresa")
public class Empresa extends Cadastro{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome", nullable = false, length = 50, unique = true)
    private String nome;
    @Column(name = "Ativa", nullable = false,length = 1)
    private String ativa;
//    @OneToMany
//    @JoinColumn(name = "empresa_cliente")
//    private List<Cliente>clientes;
}
