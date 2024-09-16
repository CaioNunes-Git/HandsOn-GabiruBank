package com.horizon.gabirubank.model.dto;

import com.horizon.gabirubank.model.Conta;

import com.horizon.gabirubank.model.enums.TipoContaEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record DadosContaDTO(Long id,
                            @Valid DadosPessoaDTO pessoa,
                            @NotBlank Integer numConta,
                            @NotBlank Integer digito,
                            @NotBlank BigDecimal saldo,
                            @NotBlank TipoContaEnum tipoConta) {
    public DadosContaDTO(Conta conta){
        this(conta.getId(), new DadosPessoaDTO(conta.getPessoa()), conta.getNumConta(), conta.getDigito(), conta.getSaldo(), conta.getTipoConta());
    }
}
