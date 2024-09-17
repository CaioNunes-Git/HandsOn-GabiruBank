package com.horizon.gabirubank.model;

import com.horizon.gabirubank.model.dto.DadosPessoaDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    @Column(unique = true)
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(DadosPessoaDTO dadosPessoa) {
        this.id = dadosPessoa.id();
        this.nome = dadosPessoa.nome();
        this.telefone = dadosPessoa.telefone();
        this.cpf = dadosPessoa.cpf();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
