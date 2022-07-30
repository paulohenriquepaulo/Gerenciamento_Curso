package com.gerenciamento.curso.curso.service.impl;

import com.gerenciamento.curso.curso.exeption.ExceptionPersonalizada;
import com.gerenciamento.curso.curso.model.Aluno;
import com.gerenciamento.curso.curso.repository.AlunoRepository;
import com.gerenciamento.curso.curso.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno cadastrarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public List<Aluno> buscarAluno(Aluno aluno) {
        validarID(aluno.getId());
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(aluno, matcher);
        List<Aluno> alunoList = alunoRepository.findAll(example);
        return alunoList;
    }

    private void validarID(Integer id) {
        if (id != null) {
            if (!alunoRepository.existsById(id)) {
                throw new ExceptionPersonalizada("mensagem", "ID invalido");
            }
        }
    }
}
