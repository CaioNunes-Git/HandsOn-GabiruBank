package com.horizon.gabirubank.repository;

import com.horizon.gabirubank.model.Transferencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<Transferencia,Long> {
    //Page<Transferencia> transferencias(Pageable paginacao);
}
