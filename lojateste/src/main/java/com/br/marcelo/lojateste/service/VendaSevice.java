package com.br.marcelo.lojateste.service;

import com.br.marcelo.lojateste.dto.ClienteDto;
import com.br.marcelo.lojateste.dto.VendasDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface VendaSevice {
    VendasDto save(VendasDto dto);
    Page<VendasDto> findAll(Pageable pageable);
    Optional<VendasDto> findById(Long id);
    VendasDto update(Long id, VendasDto dto);
    void delete(Long id);
}
