package com.br.marcelo.lojateste.repository;

import com.br.marcelo.lojateste.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    public Optional<Pagamento> findByDescricao(String descricao);

}
