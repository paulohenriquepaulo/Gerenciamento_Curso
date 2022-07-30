package com.gerenciamento.curso.curso.service.impl;

import com.gerenciamento.curso.curso.mapper.CursoMapper;
import com.gerenciamento.curso.curso.model.Aluno;
import com.gerenciamento.curso.curso.model.Curso;
import com.gerenciamento.curso.curso.model.enums.Processo;
import com.gerenciamento.curso.curso.repository.CursoRepository;
import com.gerenciamento.curso.curso.service.CursoSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CursoServiceImpl implements CursoSevice {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoMapper cursoMapper;

    @Autowired
    private AlunoServiceImpl alunoService;

    @Override
    public Curso cadastrarCurso(Curso curso, Integer dias) {
        Curso novoCurso = cursoMapper.toCurso(curso);
        Aluno aluno = alunoService.buscarAlunoPorID(curso.getAluno().getId());
        novoCurso.setAluno(aluno);
        novoCurso.setProcesso(Processo.ANDAMENTO);
        novoCurso.setPrevisaoConclusao(LocalDate.now().plusDays(dias));
        novoCurso.setDataInicio(LocalDate.now());
        return cursoRepository.save(novoCurso);
    }

}
