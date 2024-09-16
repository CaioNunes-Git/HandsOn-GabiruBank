package com.horizon.gabirubank.controller;

import com.horizon.gabirubank.model.dto.DadosContaDTO;
import com.horizon.gabirubank.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    public ContaService contaService;

    @GetMapping
    public ResponseEntity<Page<DadosContaDTO>> listarTodos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return ResponseEntity.ok(contaService.listarTodos(paginacao));
    }

    @GetMapping("/{id}")
     public ResponseEntity<Optional<DadosContaDTO>> buscarPorId (@PathVariable Long id){
         return ResponseEntity.ok(contaService.buscarContaPorId(id));
     }

     @PostMapping
     @Transactional
     public ResponseEntity<DadosContaDTO> cadastrar (@RequestBody DadosContaDTO dadosContaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.cadastrar(dadosContaDTO));
     }

     @GetMapping("/saldo/{id}")
     public BigDecimal buscarSaldoPorId(@PathVariable Long id){
        return contaService.buscarSaldoPorId(id);
     }

     @PostMapping("/depositar/{id}")
     @Transactional
     public ResponseEntity<DadosContaDTO> depositar (@PathVariable Long id, @RequestBody BigDecimal valor) {
        return ResponseEntity.ok(contaService.depositar(id, valor));
     }

    @PostMapping("/sacar/{id}")
    @Transactional
    public ResponseEntity<DadosContaDTO> sacar (@PathVariable Long id, @RequestBody BigDecimal valor) {
        return ResponseEntity.ok(contaService.sacar(id,valor));
    }
}
