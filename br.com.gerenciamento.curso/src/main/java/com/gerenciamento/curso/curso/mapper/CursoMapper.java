package com.gerenciamento.curso.curso.mapper;

import com.gerenciamento.curso.curso.dto.curso.CursoBuscarDTO;
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

    @Mapping(target = "aluno.id", source = "id_aluno")
    @Mapping(target = "aluno.nome", source = "nomeAluno")
    @Mapping(target = "id", source = "id_curso")
    Curso toCurso(CursoBuscarDTO dto);

    CursoResponseDTO toCursoResponseDTO(Curso curso);
}
