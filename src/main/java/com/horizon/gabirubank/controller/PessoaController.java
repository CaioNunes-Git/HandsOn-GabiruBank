package com.horizon.gabirubank.controller;

import com.horizon.gabirubank.model.Pessoa;
import com.horizon.gabirubank.model.dto.DadosPessoaDTO;
import com.horizon.gabirubank.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<Page<DadosPessoaDTO>> listarTodos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return ResponseEntity.ok(pessoaService.listarTodos(paginacao));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosPessoaDTO> cadastrar(@RequestBody DadosPessoaDTO dadosPessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvar(dadosPessoa));
    }
}
