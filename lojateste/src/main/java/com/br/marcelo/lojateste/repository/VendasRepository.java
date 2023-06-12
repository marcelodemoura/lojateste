package com.br.marcelo.lojateste.repository;

import com.br.marcelo.lojateste.entity.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendasRepository extends JpaRepository<Vendas, Long> {
    Optional<Vendas> findByCliente(String cliente);
}
