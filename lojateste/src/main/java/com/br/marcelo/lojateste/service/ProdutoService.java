package com.br.marcelo.lojateste.service;

import com.br.marcelo.lojateste.dto.ProdutoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProdutoService {
    ProdutoDto save(ProdutoDto dto);
    Page<ProdutoDto> findAll(Pageable pageable);
    Optional<ProdutoDto> findById(Long id);
    ProdutoDto update(Long id, ProdutoDto dto);
    void delete(Long id);


}
