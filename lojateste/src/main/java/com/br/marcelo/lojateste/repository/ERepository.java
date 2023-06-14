package com.br.marcelo.lojateste.repository;

import com.br.marcelo.lojateste.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ERepository extends JpaRepository<Empresa, Long> {
}
