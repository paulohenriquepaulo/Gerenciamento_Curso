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
        validarEmail(aluno.getEmail());
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
        String email = buscarAlunoPorID(id).getEmail();
        verificarAlunoPodeSerDeletado(id, email);
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

    public Aluno buscarAlunoPorEmail(String email) {
        if (!alunoRepository.existsByEmail(email)) {
            throw new ExceptionPersonalizada("mensagem", "Não existe Aluno cadastrado com este e-mail.");
        }
        return alunoRepository.findByEmail(email);

    }
    private void validarEmail(String email){
        if (alunoRepository.existsByEmail(email)) {
            throw new ExceptionPersonalizada("mensagem", "E-mail já cadastrado.");
        }
    }

    public Aluno buscarAlunoPorID(Integer id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ExceptionPersonalizada("mensagem", "Aluno não cadastrado."));
    }

    public void verificarAlunoPodeSerDeletado(Integer id_aluno, String email) {
            if (!cursoRepository.findByIdAluno(id_aluno).isEmpty()) {
                throw new ExceptionPersonalizada("mensagem", "Este aluno não pode ser excluido, está vinculado a um ou mais cursos.");
            } else if (alunoRepository.existsByEmail(email)) {
                throw new ExceptionPersonalizada("mensagem", "Este aluno não pode ser excluido, está vinculado a um ou mais acompanhamento");
            }
    }
}
