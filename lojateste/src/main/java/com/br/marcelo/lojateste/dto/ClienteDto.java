package com.br.marcelo.lojateste.dto;

import com.br.marcelo.lojateste.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    private String nome;
    @CPF
    private String empresa;
    @Email
    private String email;
    private String telefone;

    public ClienteDto(Cliente entity) {
        this.nome = entity.getNome();
        this.empresa = entity.getEmpresa();
        this.email = entity.getEmail();
        this.telefone = entity.getTelefone();
    }




}
