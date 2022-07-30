package com.gerenciamento.curso.curso.service;

import com.gerenciamento.curso.curso.model.Curso;

public interface CursoSevice {

    Curso cadastrarCurso(Curso curso, Integer dias);
}
