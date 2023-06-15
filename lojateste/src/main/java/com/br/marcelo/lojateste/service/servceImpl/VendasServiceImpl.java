package com.br.marcelo.lojateste.service.servceImpl;

import com.br.marcelo.lojateste.dto.VendasDto;
import com.br.marcelo.lojateste.entity.Vendas;
import com.br.marcelo.lojateste.repository.VendasRepository;
import com.br.marcelo.lojateste.service.VendasSevice;
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
public class VendasServiceImpl implements VendasSevice {

    @Autowired
    private VendasRepository repository;

    @Override
    public VendasDto save(VendasDto dto) {
        Vendas entity = new Vendas();
        BeanUtils.copyProperties(dto, entity);
        this.validationCliente(entity);
        entity.setDatacadastro(LocalDateTime.now());
        repository.save(entity);
        return dto;
    }


    @Override
    public Page<VendasDto> findAll(Pageable pageable) {
        Page<Vendas> list = repository.findAll(pageable);
        return list.map(x -> new VendasDto(x));
    }

    @Override
    public Optional<VendasDto> findById(Long id) {
        Optional<Vendas> vendasOptional = repository.findById(id);
        Vendas entity = vendasOptional.orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
        return Optional.of(new VendasDto(entity));
    }

    @Override
    public VendasDto update(Long id, VendasDto dto) {
        Vendas entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
        if (dto.getTPdoces() != null) {
            entity.setTPdoces(dto.getTPdoces());
        }
        if (dto.getQtde() != null) {
            entity.setQtde(dto.getQtde());
        }
        if (dto.getQTotal() != null) {
            entity.setQTotal(dto.getQTotal());
        }
        if (dto.getCliente() != null) {
            entity.setCliente(dto.getCliente());
        }
        if (dto.getFPagamento() != null) {
            entity.setFPagamento(dto.getFPagamento());
        }
//        if (dto.getDtCompra() != null) {
//            entity.setDtCompra(dto.getDtCompra());
//        }
//        if (dto.getDtPagamento() != null) {
//            entity.setDtPagamento(dto.getDtPagamento());
//        }
        if (dto.getVPago() != null) {
            entity.setVPago(dto.getVPago());
        }
        if (dto.getPago() != null) {
            entity.setPago(dto.getPago());
        }
        entity.setDataAtualizacao(LocalDateTime.now());
        repository.save(entity);
        return new VendasDto(entity);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("Usuario de" + id + "não encontrado."));
        repository.findById(id);

    }

    @Override
    public void validationCliente(Vendas entity) {
        Optional<Vendas> vendasOptional = repository.findByCliente(entity.getCliente());
        if (vendasOptional.isPresent()) {
            throw new BadRequestException("Descrição esxistente!");
        }
    }


}



