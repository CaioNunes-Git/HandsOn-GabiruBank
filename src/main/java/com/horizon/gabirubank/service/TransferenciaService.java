package com.horizon.gabirubank.service;

import com.horizon.gabirubank.model.Conta;
import com.horizon.gabirubank.model.Transferencia;
import com.horizon.gabirubank.model.dto.TransferenciaDTO;
import com.horizon.gabirubank.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService {

    @Autowired
    public TransferenciaRepository transferenciaRepository;

    @Autowired
    public ContaService contaService;

    public TransferenciaDTO transferir(TransferenciaDTO transferenciaDTO) {

        var contaOrigem = contaService.buscarContaPorId(transferenciaDTO.contaOrigem().getId());
        var contaDestino = contaService.buscarContaPorId(transferenciaDTO.contaDestino().getId());
        //Efetuar a transferencia
        contaService.sacar(contaOrigem.get().id(), transferenciaDTO.valor());
        contaService.depositar(contaDestino.get().id(), transferenciaDTO.valor());
        //popular a transferência
        var transferenciaMontada = new Transferencia(transferenciaDTO.id(),new Conta(contaOrigem.get()),new Conta(contaDestino.get()),transferenciaDTO.valor());

        return new TransferenciaDTO(transferenciaRepository.save(transferenciaMontada));
    }

}
