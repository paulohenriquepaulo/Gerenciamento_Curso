package com.gerenciamento.curso.curso.controller;

import com.gerenciamento.curso.curso.dto.aluno.AlunoAtualizarDTO;
import com.gerenciamento.curso.curso.dto.aluno.AlunoResponseDTO;
import com.gerenciamento.curso.curso.dto.curso.CursoAtualizarDTO;
import com.gerenciamento.curso.curso.dto.curso.CursoBuscarDTO;
import com.gerenciamento.curso.curso.dto.curso.CursoRequestDTO;
import com.gerenciamento.curso.curso.dto.curso.CursoResponseDTO;
import com.gerenciamento.curso.curso.mapper.CursoMapper;
import com.gerenciamento.curso.curso.model.Aluno;
import com.gerenciamento.curso.curso.model.Curso;
import com.gerenciamento.curso.curso.service.impl.CursoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoServiceImpl cursoService;

    @Autowired
    private CursoMapper cursoMapper;


    @PostMapping
    public ResponseEntity<CursoResponseDTO> cadastrarCurso(@RequestBody CursoRequestDTO dto) {
        Curso curso = cursoService.cadastrarCurso(cursoMapper.toCurso(dto), dto.getQuantidadeDiasConcluir());
        return ResponseEntity.ok().body(cursoMapper.toCursoResponseDTO(curso));
    }

    @PatchMapping("{id}")
    public ResponseEntity concluirCurso(@PathVariable Integer id) {
        cursoService.concluirCursoPorId(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity buscarCurso(CursoBuscarDTO cursoBuscarDTO) {
        List<Curso> cursos =  cursoService.buscarCurso(cursoMapper.toCurso(cursoBuscarDTO));
        return ResponseEntity.ok(cursos);
    }
    @PatchMapping
    public ResponseEntity<CursoResponseDTO> atualizarAluno(@RequestBody @Valid CursoAtualizarDTO dto ) {
        Curso cursoAtualizado  = cursoService.atualizarCurso(cursoMapper.toCurso(dto), dto.getQuantidadeDiasConcluir() );
        return ResponseEntity.ok(cursoMapper.toCursoResponseDTO(cursoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarCurso(@PathVariable Integer id) {
        cursoService.deletarCursoPorId(id);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity deletarTodosCurso(@PathVariable Integer id) {
        cursoService.deletarTodosCursoAluno(id);
        return ResponseEntity.notFound().build();
    }

}
