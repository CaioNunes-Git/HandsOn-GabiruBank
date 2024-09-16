package com.horizon.gabirubank.repository;

import com.horizon.gabirubank.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(value = "select * from pessoa", nativeQuery = true)
    Page<Pessoa> listarTodos(Pageable paginacao);

    @Query(value = "select * from pessoa where cpf = ?1", nativeQuery = true)
    Optional<Pessoa> buscarPessoaPorCpf(String cpf);
}
