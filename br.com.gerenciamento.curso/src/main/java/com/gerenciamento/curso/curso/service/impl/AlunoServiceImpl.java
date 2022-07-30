package com.gerenciamento.curso.curso.service.impl;

import com.gerenciamento.curso.curso.exeption.ExceptionPersonalizada;
import com.gerenciamento.curso.curso.mapper.AlunoMapper;
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

    @Autowired
    private AlunoMapper alunoMapper;

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

    @Override
    public void deletarAlunoPoID(Integer id) {
        validarID(id);
        alunoRepository.deleteById(id);
    }

    @Override
    public Aluno atualizarAluno(Aluno aluno) {
        validarID(aluno.getId());
        alunoMapper.toAluno(aluno);
        return alunoRepository.save(alunoMapper.toAluno(aluno));
    }

    private void validarID(Integer id) {
        if (id != null) {
            if (!alunoRepository.existsById(id)) {
                throw new ExceptionPersonalizada("mensagem", "ID invalido");
            }
        }
    }

    public Aluno buscarAlunoPorID(Integer id) {
        return alunoRepository.findById(id)
                .orElseThrow(( )-> new ExceptionPersonalizada("mensagem", "Aluno não cadastrado."));
    }
}
