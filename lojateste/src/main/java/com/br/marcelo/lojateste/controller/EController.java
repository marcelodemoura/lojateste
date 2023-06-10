package com.br.marcelo.lojateste.controller;


import com.br.marcelo.lojateste.dto.EmpresaDto;
import com.br.marcelo.lojateste.service.servceImpl.EServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/empresa")
public class EController {

    @Autowired
    private EServiceImpl service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public EmpresaDto salvar(@RequestBody EmpresaDto dto) {
        return service.save(dto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<EmpresaDto> listarTodos(@PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<EmpresaDto> buscarId(@PathVariable Long id) {
        Optional<EmpresaDto> dto = service.findById(id);
        return dto;
    }


    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EmpresaDto atualizar(@PathVariable Long id, @RequestBody EmpresaDto dto) {
        dto = service.update(id, dto);
        return dto;
    }

    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public EmpresaDto apagar(@PathVariable Long id) {
        service.delete(id);
        return new EmpresaDto();
    }



}
