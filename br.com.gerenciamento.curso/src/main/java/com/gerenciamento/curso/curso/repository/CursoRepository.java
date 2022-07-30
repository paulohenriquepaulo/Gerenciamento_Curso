package com.gerenciamento.curso.curso.repository;

import com.gerenciamento.curso.curso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Integer> {
}
