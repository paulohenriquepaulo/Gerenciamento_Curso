package com.gerenciamento.curso.curso.mapper;

import com.gerenciamento.curso.curso.dto.AlunoRequestDTO;
import com.gerenciamento.curso.curso.dto.AlunoResponseDTO;
import com.gerenciamento.curso.curso.model.Aluno;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    Aluno toAluno(AlunoRequestDTO dto);

    AlunoResponseDTO toAlunoResponseDTO(Aluno aluno);
}
