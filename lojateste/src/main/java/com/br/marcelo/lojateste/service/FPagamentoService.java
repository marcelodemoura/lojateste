package com.br.marcelo.lojateste.service;

import com.br.marcelo.lojateste.dto.FPagamentoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface FPagamentoService {
    FPagamentoDto save(FPagamentoDto dto);
    Page<FPagamentoDto> findAll(Pageable pageable);
    Optional<FPagamentoDto> findById(Long id);
    FPagamentoDto update(Long id, FPagamentoDto dto);
    void delete(Long id);
}
