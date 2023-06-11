package com.br.marcelo.lojateste.service.servceImpl;

import com.br.marcelo.lojateste.dto.ClienteDto;
import com.br.marcelo.lojateste.entity.Cliente;
import com.br.marcelo.lojateste.repository.ClienteRepository;
import com.br.marcelo.lojateste.service.ClienteService;
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
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;


    @Override
    public ClienteDto save(ClienteDto dto) {
        Cliente entity = new Cliente();
        BeanUtils.copyProperties(dto, entity);
        this.validationCpf(entity);
        entity.setDatacadastro(LocalDateTime.now());
        repository.save(entity);
        return dto;
    }


    @Override
    public Page<ClienteDto> findAll(Pageable pageable) {
        Page<Cliente> list = repository.findAll(pageable);
        return list.map(x -> new ClienteDto(x));
    }

    @Override
    public Optional<ClienteDto> findById(Long id) {
        Optional<Cliente> clienteOptional = repository.findById(id);
        Cliente entity = clienteOptional.orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
        return Optional.of(new ClienteDto(entity));
    }

    @Override
    public Optional<ClienteDto> findBynome(String nome) {
        Optional<Cliente> clienteOptional = repository.findByNome(nome);
        Cliente entity = clienteOptional.orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
        return Optional.of(new ClienteDto(entity));
    }


    @Override
    public ClienteDto update(Long id, ClienteDto dto) {
        Cliente entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
        if (dto.getCpf() != null) {
            entity.setCpf(dto.getCpf());
        }
        if (dto.getNome() != null) {
            entity.setNome(dto.getNome());
        }
        if (dto.getEmail() != null) {
            entity.setEmail(dto.getEmail());
        }
        if (dto.getTelefone() != null) {
            entity.setTelefone(dto.getTelefone());
        }
        entity.setDataAtualizacao(LocalDateTime.now());
        repository.save(entity);
        return new ClienteDto(entity);

    }

    @Override
    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("Usuario de" + id + "não encontrado."));
        repository.findById(id);

    }

    @Override
    public void validationCpf(Cliente entity) {
        Optional<Cliente> clienteOptional = repository.findByCpf(entity.getCpf());
        if (clienteOptional.isPresent()) {
            throw new BadRequestException("Cpf cadastrado!");
        }

    }

}
