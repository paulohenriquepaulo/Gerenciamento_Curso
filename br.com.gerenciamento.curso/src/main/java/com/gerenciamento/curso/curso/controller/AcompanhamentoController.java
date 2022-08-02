package com.gerenciamento.curso.curso.controller;

import com.gerenciamento.curso.curso.dto.acompanhamento.AcompanhamentoBuscarDTO;
import com.gerenciamento.curso.curso.dto.acompanhamento.AcompanhamentoResponseDTO;
import com.gerenciamento.curso.curso.dto.acompanhamento.AcompanhamentoResquestDTO;
import com.gerenciamento.curso.curso.dto.curso.CursoBuscarDTO;
import com.gerenciamento.curso.curso.mapper.AcompanhamentoMapper;
import com.gerenciamento.curso.curso.model.Acompanhamento;
import com.gerenciamento.curso.curso.service.impl.AcompanhamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/acompanhamento")
public class AcompanhamentoController {

    @Autowired
    private AcompanhamentoServiceImpl acompanhamentoService;

    @Autowired
    private AcompanhamentoMapper acompanhamentoMapper;

    @PostMapping
    public ResponseEntity<AcompanhamentoResponseDTO> registrarAcompanhamento(@RequestBody @Valid AcompanhamentoResquestDTO dto) {
        Acompanhamento acompanhamento = acompanhamentoMapper.toAcompanhamento(dto);
        Acompanhamento novoAcompanhamento = acompanhamentoService.registrarAcompanhamento(acompanhamento);
        return ResponseEntity.ok(acompanhamentoMapper.toAcompanhamentoResponseDTO(novoAcompanhamento));
    }

    @GetMapping
    public ResponseEntity buscarAcompanhamnetoDaSemana(@RequestBody  AcompanhamentoBuscarDTO dto) {
        List<Acompanhamento> acompanhamentos = acompanhamentoService.buscarAcompanhamentoDaSemanaDoAluno(dto.getEmail());
        return ResponseEntity.ok(acompanhamentos);
    }
}
