package com.br.marcelo.lojateste.service;

import com.br.marcelo.lojateste.dto.PagamentoDto;
import com.br.marcelo.lojateste.entity.Pagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PagamentoService {
    public PagamentoDto save(PagamentoDto dto);
    public Page<PagamentoDto> findAll(Pageable pageable);
    public Optional<PagamentoDto> findById(Long id);
    public PagamentoDto update(Long id, PagamentoDto dto);
    void delete(Long id);
    void validationDescricao(Pagamento entity);


}
