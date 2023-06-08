package com.br.marcelo.lojateste.repository;

import com.br.marcelo.lojateste.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public Optional<Cliente>findByCpf(String cpf);
    Optional<Cliente> findByNome(String nome);
}
