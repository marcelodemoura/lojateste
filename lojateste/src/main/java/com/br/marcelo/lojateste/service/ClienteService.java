package com.br.marcelo.lojateste.service;

import com.br.marcelo.lojateste.dto.ClienteDto;
import com.br.marcelo.lojateste.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClienteService {
    ClienteDto save(ClienteDto dto);
    Page<ClienteDto> findAll(Pageable pageable);
    Optional<ClienteDto> findById(Long id);
    Optional<ClienteDto>findBynome(String nome);
    ClienteDto update(Long id, ClienteDto dto);
    void delete(Long id);

    void validationCpf(Cliente entity);
}
