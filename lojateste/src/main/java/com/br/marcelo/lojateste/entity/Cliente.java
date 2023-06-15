package com.br.marcelo.lojateste.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;


@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class Cliente extends Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, name = "empresa", nullable = false)
    private String empresa;
    @Column(name = "Email", length = 30, nullable = false)
    @Email
    private String email;

    @Column(length = 50, name = "Nome", nullable = false, unique = true)
    private String nome;
    @Column(name = "Telefone", length = 15, nullable = false)
    private String telefone;

    @ManyToMany(mappedBy = "clientes")
    private List<Vendas>vendas;



}
