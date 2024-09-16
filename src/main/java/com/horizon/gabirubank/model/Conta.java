package com.horizon.gabirubank.model;

import com.horizon.gabirubank.model.dto.DadosContaDTO;
import com.horizon.gabirubank.model.enums.TipoContaEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    private Integer numConta;
    private Integer digito;
    private BigDecimal saldo;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_conta")
    private TipoContaEnum tipoConta;

    public Conta() {
    }

    public Conta(Long id, Pessoa pessoa, Integer numConta, Integer digito, BigDecimal saldo, TipoContaEnum tipoConta) {
        this.id = id;
        this.pessoa = pessoa;
        this.numConta = numConta;
        this.digito = digito;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
    }

    public Conta(DadosContaDTO dadosContaDTO) {
        this.id = dadosContaDTO.id();
        this.pessoa = new Pessoa(dadosContaDTO.pessoa());
        this.numConta = dadosContaDTO.numConta();
        this.digito = dadosContaDTO.digito();
        this.saldo = dadosContaDTO.saldo();
        this.tipoConta = dadosContaDTO.tipoConta();
    }

    public Long getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Integer getNumConta() {
        return numConta;
    }

    public void setNumConta(Integer numConta) {
        this.numConta = numConta;
    }

    public Integer getDigito() {
        return digito;
    }

    public void setDigito(Integer digito) {
        this.digito = digito;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public TipoContaEnum getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoContaEnum tipoConta) {
        this.tipoConta = tipoConta;
    }

}
