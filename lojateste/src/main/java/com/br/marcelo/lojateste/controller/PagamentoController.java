package com.br.marcelo.lojateste.controller;

import com.br.marcelo.lojateste.dto.PagamentoDto;
import com.br.marcelo.lojateste.service.servceImpl.PagamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    @Autowired
    private PagamentoServiceImpl service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PagamentoDto salvar(@RequestBody PagamentoDto dto) {
        return service.save(dto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<PagamentoDto> listarTodos(@PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<PagamentoDto> buscarId(@PathVariable Long id) {
        Optional<PagamentoDto> dto = service.findById(id);
        return dto;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PagamentoDto atualizar(@PathVariable Long id, @RequestBody PagamentoDto dto) {
        dto = service.update(id, dto);
        return dto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PagamentoDto apagar(@PathVariable Long id) {
        service.delete(id);
        return new PagamentoDto();
    }


}
