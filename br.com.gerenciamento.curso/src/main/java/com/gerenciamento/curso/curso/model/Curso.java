package com.gerenciamento.curso.curso.model;

import com.gerenciamento.curso.curso.model.enums.Processo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Curso {

    @Id
    private Integer id;

    private String nomeCurso;

    private Integer cargaHoraria;

    private LocalDate dataInicio;

    private LocalDate previsaoConclusao;

    private Processo processo;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getPrevisaoConclusao() {
        return previsaoConclusao;
    }

    public void setPrevisaoConclusao(LocalDate previsaoConclusao) {
        this.previsaoConclusao = previsaoConclusao;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
