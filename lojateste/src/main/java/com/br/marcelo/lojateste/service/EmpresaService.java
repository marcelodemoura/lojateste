package com.br.marcelo.lojateste.service;

import com.br.marcelo.lojateste.dto.EmpresaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmpresaService {
    EmpresaDto save(EmpresaDto dto);
    Page<EmpresaDto> findAll(Pageable pageable);
    Optional<EmpresaDto> findById(Long id);
    EmpresaDto update(Long id, EmpresaDto dto);
    void delete(Long id);
}
