package com.br.marcelo.lojateste.repository;

import com.br.marcelo.lojateste.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
   public Optional<Produto> findBydescricao(String descricao);
}
