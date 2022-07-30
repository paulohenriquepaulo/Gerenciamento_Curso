package com.gerenciamento.curso.curso.dto.curso;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CursoRequestDTO {

    @NotEmpty(message = "O nome do curso não pode ser nulo ou vazio.")
    private String nomeCurso;

    @NotNull(message = "A carga horaria do curso não pode ser nulo ou vazia.")
    private Integer cargaHoraria;

    private Integer quantidadeDiasConcluir;


    private Integer id_aluno;

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getQuantidadeDiasConcluir() {
        return quantidadeDiasConcluir;
    }

    public void setQuantidadeDiasConcluir(Integer quantidadeDiasConcluir) {
        this.quantidadeDiasConcluir = quantidadeDiasConcluir;
    }

    public Integer getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(Integer id_aluno) {
        this.id_aluno = id_aluno;
    }

}
