package com.br.marcelo.lojateste.repository;

import com.br.marcelo.lojateste.entity.Cliente;
import com.br.marcelo.lojateste.entity.Doces;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoceRepository extends JpaRepository<Doces, Long> {
   public Optional<Doces> findBydescricao(String descricao);
}
