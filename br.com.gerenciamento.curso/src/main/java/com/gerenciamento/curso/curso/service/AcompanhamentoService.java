package com.gerenciamento.curso.curso.service;

import com.gerenciamento.curso.curso.model.Acompanhamento;

import java.util.List;

public interface AcompanhamentoService {

    Acompanhamento registrarAcompanhamento(Acompanhamento acompanhamento);

    List<Acompanhamento> buscarAcompanhamentoDaSemanaDoAluno(String email);
}
