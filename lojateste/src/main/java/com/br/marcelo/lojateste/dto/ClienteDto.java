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
    private String cpf;
    @Email
    private String email;
    private String telefone;

    public ClienteDto(Cliente entity) {
        this.nome = entity.getNome();
        this.cpf = entity.getCpf();
        this.email = entity.getEmail();
        this.telefone = entity.getTelefone();
    }
}
