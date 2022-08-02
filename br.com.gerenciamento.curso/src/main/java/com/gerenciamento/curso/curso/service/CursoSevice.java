package com.gerenciamento.curso.curso.service;

import com.gerenciamento.curso.curso.dto.curso.CursoRequestDTO;
import com.gerenciamento.curso.curso.model.Curso;

import java.util.List;

public interface CursoSevice {

    Curso cadastrarCurso(CursoRequestDTO dto);

    void concluirCursoPorId(Integer id_curso);

    List<Curso> buscarCurso(Curso curso);

    void deletarCursoPorId(Integer id);

    void deletarTodosCursoAluno(Integer id_aluno);

    Curso atualizarCurso(Curso curso, Integer dias);
}
