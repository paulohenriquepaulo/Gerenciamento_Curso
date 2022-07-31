package com.gerenciamento.curso.curso.controller;

import com.gerenciamento.curso.curso.dto.AcompanhamentoResponseDTO;
import com.gerenciamento.curso.curso.dto.AcompanhamentoResquestDTO;
import com.gerenciamento.curso.curso.mapper.AcompanhamentoMapper;
import com.gerenciamento.curso.curso.model.Acompanhamento;
import com.gerenciamento.curso.curso.service.impl.AcompanhamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
