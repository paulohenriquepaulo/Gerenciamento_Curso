package com.gerenciamento.curso.curso.controller;

import com.gerenciamento.curso.curso.dto.curso.CursoRequestDTO;
import com.gerenciamento.curso.curso.dto.curso.CursoResponseDTO;
import com.gerenciamento.curso.curso.mapper.CursoMapper;
import com.gerenciamento.curso.curso.model.Curso;
import com.gerenciamento.curso.curso.service.impl.CursoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
