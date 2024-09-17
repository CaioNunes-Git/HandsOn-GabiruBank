package com.horizon.gabirubank.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.horizon.gabirubank.model.Conta;
import com.horizon.gabirubank.model.Transferencia;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransferenciaDTO(
        Long id,
        @NotBlank Conta contaOrigem,
        @NotBlank Conta contaDestino,
        @NotBlank BigDecimal valor,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime data) {
    public TransferenciaDTO(Transferencia transferencia){
        this(transferencia.getId(), transferencia.getContaOrigem(), transferencia.getContaDestino(),transferencia.getValor(),transferencia.getData());
    }
}
