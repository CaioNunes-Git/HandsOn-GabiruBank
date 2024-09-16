package com.horizon.gabirubank.controller;

import com.horizon.gabirubank.model.dto.TransferenciaDTO;
import com.horizon.gabirubank.service.TransferenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    public TransferenciaService tranferenciaService;

    @PostMapping("/{idContaOrigem}/{idContaDestino}")
    @Transactional
    public ResponseEntity<TransferenciaDTO> transferir (@RequestBody TransferenciaDTO transferenciaDTO){
        return ResponseEntity.ok(tranferenciaService.transferir(transferenciaDTO));
    }
}
