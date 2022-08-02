package com.gerenciamento.curso.curso.repository;

import com.gerenciamento.curso.curso.model.Acompanhamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AcompanhamentoRepository extends JpaRepository<Acompanhamento, Integer> {

    @Query(value = "select * from acompanhamento where aluno_id = :aluno_id limit 5", nativeQuery = true )
    List<Acompanhamento> findAllByIdLimite(Integer aluno_id);
}
