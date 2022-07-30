package com.gerenciamento.curso.curso.service.impl;

import com.gerenciamento.curso.curso.exeption.ExceptionPersonalizada;
import com.gerenciamento.curso.curso.mapper.CursoMapper;
import com.gerenciamento.curso.curso.model.Aluno;
import com.gerenciamento.curso.curso.model.Curso;
import com.gerenciamento.curso.curso.model.enums.Processo;
import com.gerenciamento.curso.curso.repository.CursoRepository;
import com.gerenciamento.curso.curso.service.CursoSevice;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    @Override
    public void concluirCursoPorId(Integer id_curso) {
        validarCurso(id_curso);
        Curso curso = cursoRepository.getById(id_curso);
        curso.setProcesso(Processo.CONCLUIDO);
        cursoRepository.save(curso);
    }

    @Override
    public List<Curso> buscarCurso(Curso curso) {
        validarCurso(curso.getId());
        alunoService.validarAlunoPorID(curso.getAluno().getId());
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(curso, matcher);
        List<Curso> cursoList = cursoRepository.findAll(example);
        for (int i = 0; i < cursoList.size(); i++) {
            int x = cursoList.get(i).getPrevisaoConclusao().compareTo(LocalDate.now());
            if (cursoList.get(i).getProcesso().equals(Processo.CONCLUIDO)) {
                break;
            } else if (x < 0) {
                cursoList.get(i).setProcesso(Processo.ATRASADO);
                cursoRepository.save(cursoList.get(i));
            }
        }
        return cursoList;
    }

    @Override
    public void deletarCursoPorId(Integer id) {
        validarCurso(id);
        cursoRepository.deleteById(id);
    }

    @Override
    public Curso atualizarCurso(Curso curso, Integer dias) {
        validarCurso(curso.getId());
        Curso cursoAtualizado = cursoRepository.getById(curso.getId());
        if (StringUtils.isNotBlank(curso.getNomeCurso())) {
            cursoAtualizado.setNomeCurso(curso.getNomeCurso());
        }
        if (curso.getCargaHoraria() != null) {
            cursoAtualizado.setCargaHoraria(curso.getCargaHoraria());
        }
        if (dias != null) {
            cursoAtualizado.setPrevisaoConclusao(LocalDate.now().plusDays(dias));
            int x = cursoAtualizado.getPrevisaoConclusao().compareTo(LocalDate.now());
            if (!cursoAtualizado.getProcesso().equals(Processo.CONCLUIDO)) {
                if (x >= 0) {
                    cursoAtualizado.setProcesso(Processo.ANDAMENTO);
                } else {
                    cursoAtualizado.setProcesso(Processo.ATRASADO);
                }
            }
        }
        return cursoRepository.save(cursoAtualizado);
    }

    private void validarCurso(Integer id_curso) {
        if (id_curso != null) {
            cursoRepository.findById(id_curso)
                    .orElseThrow(() -> new ExceptionPersonalizada("mensagem", "Curso não encontrado."));
        }
    }
}
