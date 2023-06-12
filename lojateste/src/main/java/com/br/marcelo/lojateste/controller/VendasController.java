package com.br.marcelo.lojateste.controller;

import com.br.marcelo.lojateste.dto.VendasDto;
import com.br.marcelo.lojateste.service.servceImpl.VendasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    @Autowired
    private VendasServiceImpl service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public VendasDto salvar(@RequestBody VendasDto dto) {
        return service.save(dto);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<VendasDto> listar(@PageableDefault(page = 0, size =10, sort = "id") Pageable pageable){
        return service.findAll(pageable);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<VendasDto> listarId(@PathVariable Long id){
        Optional<VendasDto>dto = service.findById(id);
        return dto;
    }
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendasDto atualizar(@PathVariable Long id, @RequestBody VendasDto dto){
        dto = service.update(id, dto);
        return dto;
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendasDto apagar(@PathVariable Long id) {
        service.delete(id);
        return new VendasDto();
    }

}
