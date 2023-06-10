package com.br.marcelo.lojateste.service.servceImpl;

import com.br.marcelo.lojateste.dto.EmpresaDto;
import com.br.marcelo.lojateste.service.EmpresaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EServiceImpl implements EmpresaService {
    public EmpresaDto save(EmpresaDto dto) {
        return null;
    }

    public Page<EmpresaDto> findAll(Pageable pageable) {
        return null;
    }

    public Optional<EmpresaDto> findById(Long id) {
        return null;
    }

    public EmpresaDto update(Long id, EmpresaDto dto) {
        return null;
    }
    @Override
    public void delete(Long id) {
        EServiceImpl repository = null;
        repository.findById(id);
    }
}
