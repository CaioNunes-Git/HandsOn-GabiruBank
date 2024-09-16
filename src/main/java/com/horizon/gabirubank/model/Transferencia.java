package com.horizon.gabirubank.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.horizon.gabirubank.model.dto.TransferenciaDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transferencia")
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "conta_origem_id")
    private Conta contaOrigem;
    @ManyToOne
    @JoinColumn(name = "conta_destino_id")
    private Conta contaDestino;
    private BigDecimal valor;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime data = LocalDateTime.now();

    public Transferencia(Long id, Conta contaOrigem, Conta contaDestino, BigDecimal valor) {
        this.id = id;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
    }

    public Transferencia(TransferenciaDTO transferenciaDTO){
        this.id = transferenciaDTO.id();
        this.contaOrigem = transferenciaDTO.contaOrigem();
        this.contaDestino = transferenciaDTO.contaDestino();
        this.valor = transferenciaDTO.valor();
        this.data = transferenciaDTO.data();
    }

    public Long getId() {
        return id;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }
}
