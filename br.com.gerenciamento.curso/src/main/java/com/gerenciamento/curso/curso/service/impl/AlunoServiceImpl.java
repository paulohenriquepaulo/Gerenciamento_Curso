package com.gerenciamento.curso.curso.service.impl;

import com.gerenciamento.curso.curso.exeption.ExceptionPersonalizada;
import com.gerenciamento.curso.curso.mapper.AlunoMapper;
import com.gerenciamento.curso.curso.model.Aluno;
import com.gerenciamento.curso.curso.repository.AlunoRepository;
import com.gerenciamento.curso.curso.repository.CursoRepository;
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

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Aluno cadastrarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public List<Aluno> buscarAluno(Aluno aluno) {
        validarAlunoPorID(aluno.getId());
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
        validarAlunoPorID(id);
        verificarAlunoVinculadoCurso(id);
        alunoRepository.deleteById(id);
    }

    @Override
    public Aluno atualizarAluno(Aluno aluno) {
        validarAlunoPorID(aluno.getId());
        alunoMapper.toAluno(aluno);
        return alunoRepository.save(alunoMapper.toAluno(aluno));
    }

    public void validarAlunoPorID(Integer id) {
        if (id != null) {
            if (!alunoRepository.existsById(id)) {
                throw new ExceptionPersonalizada("mensagem", "Aluno não cadastrado");
            }
        }
    }

    public Aluno buscarAlunoPorID(Integer id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ExceptionPersonalizada("mensagem", "Aluno não cadastrado."));
    }

    public void verificarAlunoVinculadoCurso(Integer id_aluno) {
            if (!cursoRepository.findByIdAluno(id_aluno).isEmpty()) {
                throw new ExceptionPersonalizada("mensagem", "Este aluno está vinculado a um ou mais cursos.");
            }
    }
}
