package com.gerenciamento.curso.curso.service.impl;

import com.gerenciamento.curso.curso.model.Aluno;
import com.gerenciamento.curso.curso.repository.AlunoRepository;
import com.gerenciamento.curso.curso.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Override
    public Aluno cadastrarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
}
