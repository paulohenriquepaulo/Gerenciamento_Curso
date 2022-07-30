package com.gerenciamento.curso.curso.mapper;

import com.gerenciamento.curso.curso.dto.aluno.AlunoBuscarDTO;
import com.gerenciamento.curso.curso.dto.aluno.AlunoRequestDTO;
import com.gerenciamento.curso.curso.dto.aluno.AlunoResponseDTO;
import com.gerenciamento.curso.curso.model.Aluno;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    Aluno toAluno(AlunoRequestDTO dto);

    Aluno toAluno(AlunoBuscarDTO dto);

    AlunoResponseDTO toAlunoResponseDTO(Aluno aluno);
}
