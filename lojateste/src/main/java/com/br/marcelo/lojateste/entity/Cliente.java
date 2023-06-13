package com.br.marcelo.lojateste.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;


@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_cliente")
public class Cliente extends Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CPF
    @Column(length = 14, name = "Cpf", nullable = false)
    private String cpf;
    @Column(name = "Email", length = 30, nullable = false)
    private String email;

    @Column(length = 50, name = "Nome", nullable = false, unique = true)
    private String nome;
    @Column(name = "Telefone", length = 15, nullable = false)
    private String telefone;
}
