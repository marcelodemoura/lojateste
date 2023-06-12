package com.br.marcelo.lojateste.service;

import com.br.marcelo.lojateste.dto.VendasDto;
import com.br.marcelo.lojateste.entity.Vendas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface VendasSevice {

    VendasDto save(VendasDto dto);

    Page<VendasDto> findAll(Pageable pageable);

    Optional<VendasDto> findById(Long id);

    VendasDto update(Long id, VendasDto dto);

    void delete(Long id);
    void validationCliente(Vendas entity);
}
