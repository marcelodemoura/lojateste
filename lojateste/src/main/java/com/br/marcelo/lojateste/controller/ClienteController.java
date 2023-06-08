package com.br.marcelo.lojateste.controller;

import com.br.marcelo.lojateste.dto.ClienteDto;
import com.br.marcelo.lojateste.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteServiceImpl service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDto salvar(@RequestBody ClienteDto dto) {
        return service.save(dto);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<ClienteDto>listarTodos(@PageableDefault(page = 0, size = 10, sort = "id")Pageable pageable){
        return service.findAll(pageable);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ClienteDto>buscarId(@PathVariable Long id){
        Optional<ClienteDto>dto = service.findById(id);
        return dto;
    }
//    @GetMapping("/{nome}")
//    @ResponseStatus(HttpStatus.OK)
//    public Optional<ClienteDto>buscarNome(@PathVariable String nome){
//        Optional<ClienteDto>dto = service.findBynome(nome);
//        return dto;
//    }
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ClienteDto atualizar(@PathVariable Long id, @RequestBody ClienteDto dto){
        dto = service.update(id, dto);
        return dto;
    }
    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public ClienteDto apagar(@PathVariable Long id){
        service.delete(id);
        return new ClienteDto();
    }






}
