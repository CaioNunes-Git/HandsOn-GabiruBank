package com.horizon.gabirubank.repository;

import com.horizon.gabirubank.model.Conta;
import com.horizon.gabirubank.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta,Long> {
    @Query(value = "select * from conta", nativeQuery = true)
    Page<Conta> listarTodos(Pageable paginacao);

    @Query(value = "select * from conta where id = ?1", nativeQuery = true)
    Optional<Conta> buscarContaPorId(Long id);

    @Query(value = "select * from conta where pessoa_id = ?1 and tipo_conta = ?2", nativeQuery = true)
    Optional<Conta> buscarContaPorIdETipo(Pessoa id, String tipoConta);
}
