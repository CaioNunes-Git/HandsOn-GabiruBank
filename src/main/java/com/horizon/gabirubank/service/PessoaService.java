package com.horizon.gabirubank.service;

import com.horizon.gabirubank.model.Pessoa;
import com.horizon.gabirubank.model.dto.DadosPessoaDTO;
import com.horizon.gabirubank.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Page<DadosPessoaDTO> listarTodos(Pageable paginacao){
        return pessoaRepository.listarTodos(paginacao).map(DadosPessoaDTO::new);
    }

    public DadosPessoaDTO salvar(DadosPessoaDTO dadosPessoa){
        Pessoa pessoa = new Pessoa(dadosPessoa);
        if (pessoaRepository.buscarPessoaPorCpf(dadosPessoa.cpf()).isPresent())
            throw new RuntimeException("CPF já cadastrado");

        return new DadosPessoaDTO(pessoaRepository.save(pessoa));
    }


}
