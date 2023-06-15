package com.br.marcelo.lojateste.controller;

import com.br.marcelo.lojateste.dto.ProdutoDto;
import com.br.marcelo.lojateste.service.servceImpl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/doces")
public class ProdutoController {
    @Autowired
    private ProdutoServiceImpl service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDto salvar(@RequestBody ProdutoDto dto) {
        return service.save(dto);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<ProdutoDto> listar(@PageableDefault(page = 0, size =10, sort = "id") Pageable pageable){
        return service.findAll(pageable);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ProdutoDto>listarId(@PathVariable Long id){
        Optional<ProdutoDto>dto = service.findById(id);
        return dto;
    }
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoDto atualizar(@PathVariable Long id, @RequestBody ProdutoDto dto){
        dto = service.update(id, dto);
        return dto;
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoDto apagar(@PathVariable Long id) {
        service.delete(id);
        return new ProdutoDto();
    }


}
