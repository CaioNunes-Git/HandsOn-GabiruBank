package com.horizon.gabirubank.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransferenciaRequestDTO(Long id,
                                      @NotNull Long contaOrigem,
                                      @NotNull Long contaDestino,
                                      @NotNull BigDecimal valor,
                                      @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                                      LocalDateTime data) {

}
