package com.gerenciamento.curso.curso.mapper;

import com.gerenciamento.curso.curso.dto.acompanhamento.AcompanhamentoResponseDTO;
import com.gerenciamento.curso.curso.dto.acompanhamento.AcompanhamentoResquestDTO;
import com.gerenciamento.curso.curso.model.Acompanhamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AcompanhamentoMapper {

    @Mapping(target = "aluno.email", source = "email")
    Acompanhamento toAcompanhamento(AcompanhamentoResquestDTO dto);

    Acompanhamento toAcompanhamento(Acompanhamento acompanhamento);

    @Mapping(target = "email", source = "aluno.email")
    @Mapping(target = "id_acompanhamento", source = "id")
    @Mapping(target = "nomeAluno", source = "aluno.nome")
    AcompanhamentoResponseDTO toAcompanhamentoResponseDTO(Acompanhamento acompanhamento);
}
