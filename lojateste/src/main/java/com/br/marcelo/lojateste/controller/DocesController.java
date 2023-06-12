package com.br.marcelo.lojateste.controller;

import com.br.marcelo.lojateste.dto.DocesDto;
import com.br.marcelo.lojateste.service.servceImpl.DocesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/doces")
public class DocesController {
    @Autowired
    private DocesServiceImpl service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public DocesDto salvar(@RequestBody DocesDto dto) {
        return service.save(dto);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<DocesDto> listar(@PageableDefault(page = 0, size =10, sort = "id") Pageable pageable){
        return service.findAll(pageable);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<DocesDto>listarId(@PathVariable Long id){
        Optional<DocesDto>dto = service.findById(id);
        return dto;
    }
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DocesDto atualizar(@PathVariable Long id, @RequestBody DocesDto dto){
        dto = service.update(id, dto);
        return dto;
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DocesDto apagar(@PathVariable Long id) {
        service.delete(id);
        return new DocesDto();
    }


}
