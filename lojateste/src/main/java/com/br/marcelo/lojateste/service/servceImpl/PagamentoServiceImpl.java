package com.br.marcelo.lojateste.service.servceImpl;

import com.br.marcelo.lojateste.dto.PagamentoDto;
import com.br.marcelo.lojateste.entity.Pagamento;
import com.br.marcelo.lojateste.repository.PagamentoRepository;
import com.br.marcelo.lojateste.service.PagamentoService;
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
public class PagamentoServiceImpl implements PagamentoService {
    @Autowired
    private PagamentoRepository repository;

    @Override
    public PagamentoDto save(PagamentoDto dto) {
        Pagamento entity = new Pagamento();
        BeanUtils.copyProperties(dto, entity);
        this.validationDescricao(entity);
        entity.setDatacadastro(LocalDateTime.now());
        repository.save(entity);
        return dto;
    }

    @Override
    public Page<PagamentoDto> findAll(Pageable pageable) {
        Page<Pagamento> list = repository.findAll(pageable);
        return list.map(x -> new PagamentoDto(x));
    }

    @Override
    public Optional<PagamentoDto> findById(Long id) {
        Optional<Pagamento> pagamentoOptional = repository.findById(id);
        Pagamento entity = pagamentoOptional.orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
        return Optional.of(new PagamentoDto(entity));
    }

    @Override
    public PagamentoDto update(Long id, PagamentoDto dto) {
        Pagamento entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
        if (dto.getDescricao() != null) {
            entity.setDescricao(dto.getDescricao());
        }
        entity.setDataAtualizacao(LocalDateTime.now());
        repository.save(entity);
        return new PagamentoDto(entity);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("Usuario de " + "não encontrado"));
        repository.findById(id);

    }

    @Override
    public void validationDescricao(Pagamento entity) {
        Optional<Pagamento> pagamentoOptional = repository.findByDescricao(entity.getDescricao());
        if (pagamentoOptional.isPresent()){
            throw new BadRequestException("Descrição cadastrada");
        }

    }
}