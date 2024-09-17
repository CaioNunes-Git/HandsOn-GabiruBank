package com.horizon.gabirubank.service;

import com.horizon.gabirubank.model.Conta;
import com.horizon.gabirubank.model.dto.DadosContaDTO;
import com.horizon.gabirubank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    ContaRepository contaRepository;

    public Page<DadosContaDTO> listarTodos(Pageable paginacao){
        return contaRepository.listarTodos(paginacao).map(DadosContaDTO::new);
    }

    public Optional<DadosContaDTO> buscarContaPorId(Long id) {
        var conta = contaRepository.buscarContaPorId(id);
        if (conta.isEmpty())
            throw new RuntimeException("Conta não Encontrada");
        return conta.map(DadosContaDTO::new);
    }

    public BigDecimal buscarSaldoPorId(Long id) {
        var conta = buscarContaPorId(id);
        if (conta.isEmpty())
            throw new RuntimeException("Conta não Encontrada");

        return conta.get().saldo();
    }

//    public Optional<DadosContaDTO> buscarContaPorCpf(String cpf) {
//        var conta = contaRepository.buscarContaPorId(id);
//        if (conta.isEmpty())
//            throw new RuntimeException("Conta não Encontrada");
//        return conta.map(DadosContaDTO::new);
//    }

    public DadosContaDTO cadastrar(DadosContaDTO dadosContaDTO) {
        var buscarConta = contaRepository.buscarContaPorPessoaIdETipo(dadosContaDTO.pessoa().id(),
                        String.valueOf(dadosContaDTO.tipoConta()));
        Conta conta = new Conta(dadosContaDTO);
        if (buscarConta.isEmpty() && dadosContaDTO.saldo().compareTo(BigDecimal.ZERO) >= 0)
            return new DadosContaDTO(contaRepository.save(conta));

        throw new RuntimeException("O usuário não foi cadastrado");
    }

    public DadosContaDTO depositar(Long id, BigDecimal valor) {
        var conta =  new Conta(buscarContaPorId(id).get());
        validarValor(valor);
        conta.setSaldo(conta.getSaldo().add(valor));

        return new DadosContaDTO(contaRepository.save(conta));
    }

    public DadosContaDTO sacar(Long id, BigDecimal valor) {
        var conta = new Conta(buscarContaPorId(id).get());
        validarValor(valor);

        if (conta.getSaldo().compareTo(valor) < 0)
            throw new RuntimeException("Saldo insuficiente");

        conta.setSaldo(conta.getSaldo().subtract(valor));
        return new DadosContaDTO(contaRepository.save(conta));
    }

    private void validarValor(BigDecimal valor){
        if (valor.compareTo(BigDecimal.ZERO) <= 0)
            throw new RuntimeException("Insira um valor maior que zero para realizar a transação");
    }
}
