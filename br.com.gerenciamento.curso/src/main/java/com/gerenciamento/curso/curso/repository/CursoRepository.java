package com.gerenciamento.curso.curso.repository;

import com.gerenciamento.curso.curso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso,Integer> {

    @Query("SELECT c FROM Curso c WHERE id_aluno = :id_aluno")
    List<Curso> findByIdAluno(@Param("id_aluno") Integer id_aluno);

}
