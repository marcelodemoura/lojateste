package com.br.marcelo.lojateste.controller;

import com.br.marcelo.lojateste.dto.FPagamentoDto;
import com.br.marcelo.lojateste.service.servceImpl.FPagamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/pagamento")
public class FPagamentoController {


        @Autowired
        private FPagamentoServiceImpl service;

        @PostMapping()
        @ResponseStatus(HttpStatus.CREATED)
        public FPagamentoDto salvar(@RequestBody FPagamentoDto dto) {
            return service.save(dto);
        }

        @GetMapping()
        @ResponseStatus(HttpStatus.OK)
        public Page<FPagamentoDto> listarTodos(@PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable) {
            return service.findAll(pageable);
        }

        @GetMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public Optional<FPagamentoDto> buscarId(@PathVariable Long id) {
            Optional<FPagamentoDto> dto = service.findById(id);
            return dto;
        }

        @PatchMapping("/{id}")
        @ResponseStatus(HttpStatus.ACCEPTED)
        public FPagamentoDto atualizar(@PathVariable Long id, @RequestBody FPagamentoDto dto) {
            dto = service.update(id, dto);
            return dto;
        }

        @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
        public FPagamentoDto apagar(@PathVariable Long id) {
            service.delete(id);
            return new FPagamentoDto();
        }


    }
