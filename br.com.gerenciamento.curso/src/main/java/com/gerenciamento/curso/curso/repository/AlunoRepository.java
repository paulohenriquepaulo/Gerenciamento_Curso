package com.gerenciamento.curso.curso.repository;

import com.gerenciamento.curso.curso.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
