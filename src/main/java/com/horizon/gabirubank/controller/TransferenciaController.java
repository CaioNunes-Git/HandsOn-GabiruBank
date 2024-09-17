package com.horizon.gabirubank.controller;

import com.horizon.gabirubank.model.dto.TransferenciaDTO;
import com.horizon.gabirubank.model.dto.TransferenciaRequestDTO;
import com.horizon.gabirubank.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    @Autowired
    public TransferenciaService tranferenciaService;

    @PostMapping
    @Transactional
    public ResponseEntity<TransferenciaDTO> transferir (@RequestBody TransferenciaRequestDTO transferenciaDTO){
        return ResponseEntity.ok(tranferenciaService.transferir(transferenciaDTO));
    }
}
