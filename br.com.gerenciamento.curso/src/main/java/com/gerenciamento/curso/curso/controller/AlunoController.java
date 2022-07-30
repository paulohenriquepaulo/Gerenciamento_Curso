package com.gerenciamento.curso.curso.controller;

import com.gerenciamento.curso.curso.dto.AlunoRequestDTO;
import com.gerenciamento.curso.curso.dto.AlunoResponseDTO;
import com.gerenciamento.curso.curso.mapper.AlunoMapper;
import com.gerenciamento.curso.curso.model.Aluno;
import com.gerenciamento.curso.curso.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

}
