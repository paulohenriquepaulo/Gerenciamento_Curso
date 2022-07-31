package com.gerenciamento.curso.curso.controller;

import com.gerenciamento.curso.curso.dto.aluno.AlunoAtualizarDTO;
import com.gerenciamento.curso.curso.dto.aluno.AlunoBuscarDTO;
import com.gerenciamento.curso.curso.dto.aluno.AlunoRequestDTO;
import com.gerenciamento.curso.curso.dto.aluno.AlunoResponseDTO;
import com.gerenciamento.curso.curso.mapper.AlunoMapper;
import com.gerenciamento.curso.curso.model.Aluno;
import com.gerenciamento.curso.curso.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl alunoService;

    @Autowired
    private AlunoMapper alunoMapper;

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> cadastrarAluno(@RequestBody @Valid AlunoRequestDTO dto) {
        Aluno aluno = alunoMapper.toAluno(dto);
        Aluno novoAluno = alunoService.cadastrarAluno(aluno);
        return ResponseEntity.ok(alunoMapper.toAlunoResponseDTO(novoAluno));
    }

    @GetMapping
    public ResponseEntity buscarAluno(AlunoBuscarDTO dto) {
        List<Aluno> alunoList = alunoService.buscarAluno(alunoMapper.toAluno(dto));
        return ResponseEntity.ok(alunoList);
    }

    @PutMapping
    public ResponseEntity<AlunoResponseDTO> atualizarAluno(@RequestBody @Valid AlunoAtualizarDTO dto) {
        Aluno alunoAtualizado = alunoService.atualizarAluno(alunoMapper.toAluno(dto));
        return ResponseEntity.ok(alunoMapper.toAlunoResponseDTO(alunoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarAluno(@PathVariable Integer id) {
        alunoService.deletarAlunoPoID(id);
        return ResponseEntity.notFound().build();
    }

}
