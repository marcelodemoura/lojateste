package com.br.marcelo.lojateste.service.servceImpl;

import com.br.marcelo.lojateste.dto.ProdutoDto;
import com.br.marcelo.lojateste.entity.Produto;
import com.br.marcelo.lojateste.repository.ProdutoRepository;
import com.br.marcelo.lojateste.service.ProdutoService;
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
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public ProdutoDto save(ProdutoDto dto) {
        Produto entity = new Produto();
        BeanUtils.copyProperties(dto, entity);
        this.validationDescricao(entity);
        entity.setDatacadastro(LocalDateTime.now());
        repository.save(entity);
        return dto;
    }


    @Override
    public Page<ProdutoDto> findAll(Pageable pageable) {
        Page<Produto> list = repository.findAll(pageable);
        return list.map(x -> new ProdutoDto(x));
    }

    @Override
    public Optional<ProdutoDto> findById(Long id) {
        Optional<Produto> docesOptional = repository.findById(id);
        Produto entity = docesOptional.orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
        return Optional.of(new ProdutoDto(entity));
    }
    @Override
    public ProdutoDto update(Long id, ProdutoDto dto) {
        Produto entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
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
        return new ProdutoDto(entity);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("Usuario de" + id + "não encontrado."));
        repository.findById(id);

    }

    private void validationDescricao(Produto entity) {
        Optional<Produto> docesOptional = repository.findBydescricao(entity.getDescricao());
        if (docesOptional.isPresent()) {
            throw new BadRequestException("Descrição esxistente!");
        }
    }
}

