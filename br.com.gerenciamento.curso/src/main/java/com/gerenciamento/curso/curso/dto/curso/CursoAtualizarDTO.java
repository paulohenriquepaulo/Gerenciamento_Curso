package com.gerenciamento.curso.curso.dto.curso;

public class CursoAtualizarDTO {

    private Integer id;

    private Integer cargaHoraria;

    private String nomeCurso;

        private Integer quantidadeDiasConcluir;

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Integer getQuantidadeDiasConcluir() {
        return quantidadeDiasConcluir;
    }

    public void setQuantidadeDiasConcluir(Integer quantidadeDiasConcluir) {
        this.quantidadeDiasConcluir = quantidadeDiasConcluir;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
