package com.br.marcelo.lojateste.service;

import com.br.marcelo.lojateste.dto.DocesDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DoceService {
    DocesDto save(DocesDto dto);
    Page<DocesDto> findAll(Pageable pageable);
    Optional<DocesDto> findById(Long id);
    DocesDto update(Long id, DocesDto dto);
    void delete(Long id);


}
