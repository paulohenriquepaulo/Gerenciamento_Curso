package com.gerenciamento.curso.curso.mapper;

import com.gerenciamento.curso.curso.dto.curso.CursoRequestDTO;
import com.gerenciamento.curso.curso.dto.curso.CursoResponseDTO;
import com.gerenciamento.curso.curso.model.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    @Mapping(target = "aluno.id", source = "id_aluno")
    Curso toCurso(CursoRequestDTO dto);

    Curso toCurso(Curso curso);

    CursoResponseDTO toCursoResponseDTO(Curso curso);
}
