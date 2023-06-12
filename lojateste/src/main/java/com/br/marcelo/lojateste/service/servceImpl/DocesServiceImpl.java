package com.br.marcelo.lojateste.service.servceImpl;

import com.br.marcelo.lojateste.dto.DocesDto;
import com.br.marcelo.lojateste.entity.Doces;
import com.br.marcelo.lojateste.repository.DoceRepository;
import com.br.marcelo.lojateste.service.DoceService;
import com.br.marcelo.lojateste.service.exception.BadRequestException;
import com.br.marcelo.lojateste.service.exception.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DocesServiceImpl implements DoceService {

    @Autowired
    private DoceRepository repository;

    @Override
    public DocesDto save(DocesDto dto) {
        Doces entity = new Doces();
        BeanUtils.copyProperties(dto, entity);
        this.validationDescricao(entity);
        entity.setDatacadastro(LocalDateTime.now());
        repository.save(entity);
        return dto;
    }


    @Override
    public Page<DocesDto> findAll(Pageable pageable) {
        Page<Doces> list = repository.findAll(pageable);
        return list.map(x -> new DocesDto(x));
    }

    @Override
    public Optional<DocesDto> findById(Long id) {
        Optional<Doces> docesOptional = repository.findById(id);
        Doces entity = docesOptional.orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
        return Optional.of(new DocesDto(entity));
    }
    @Override
    public DocesDto update(Long id, DocesDto dto) {
        Doces entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
        if (dto.getDescricao() != null) {
            entity.setDescricao(dto.getDescricao());
        }
        if (dto.getValorUnitario() != null) {
            entity.setValorUnitario(dto.getValorUnitario());
        }
        if (dto.getQtdeEstoque() != null) {
            entity.setQtdeEstoque(dto.getQtdeEstoque());
        }
        entity.setDataAtualizacao(LocalDateTime.now());
        repository.save(entity);
        return new DocesDto(entity);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("Usuario de" + id + "não encontrado."));
        repository.findById(id);

    }

    private void validationDescricao(Doces entity) {
        Optional<Doces> docesOptional = repository.findBydescricao(entity.getDescricao());
        if (docesOptional.isPresent()) {
            throw new BadRequestException("Descrição esxistente!");
        }
    }
}

