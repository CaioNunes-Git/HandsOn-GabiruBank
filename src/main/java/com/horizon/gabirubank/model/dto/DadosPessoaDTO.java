package com.horizon.gabirubank.model.dto;

import com.horizon.gabirubank.model.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosPessoaDTO(Long id,
                             @NotBlank(message = "Insira um nome válido") String nome,
                             @NotBlank(message = "Insira um telefone válido")
                             @Pattern(regexp = "\\d{11}")
                             String telefone,
                             @Pattern(regexp = "\\d{11}", message = "Digite um CPF Válido")
                             @NotNull String cpf) {
    public DadosPessoaDTO(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getTelefone(), pessoa.getCpf());
    }
}
