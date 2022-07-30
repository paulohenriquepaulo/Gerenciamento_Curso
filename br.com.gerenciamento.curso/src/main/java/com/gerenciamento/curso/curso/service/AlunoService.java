package com.gerenciamento.curso.curso.service;

import com.gerenciamento.curso.curso.model.Aluno;

import java.util.List;

public interface AlunoService {
    Aluno cadastrarAluno(Aluno aluno);

    List<Aluno> buscarAluno(Aluno aluno);

    void deletarAlunoPoID(Integer id);

    Aluno atualizarAluno(Aluno aluno);


}
