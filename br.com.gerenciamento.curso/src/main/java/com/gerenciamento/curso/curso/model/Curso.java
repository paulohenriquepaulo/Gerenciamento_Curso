package com.gerenciamento.curso.curso.model;

import com.gerenciamento.curso.curso.model.enums.Processo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "O nome do curso não pode ser nulo ou vazio.")
    private String nomeCurso;

    @NotNull(message = "A carga horaria do curso não pode ser nulo ou vazia.")
    private Integer cargaHoraria;

    @NotNull(message = "A data de inicio do curso não pode ser nulo ou vazio.")
    private LocalDate dataInicio;

    private LocalDate previsaoConclusao;

    @Enumerated(EnumType.STRING)
    private Processo processo;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    @NotNull(message = "O id do aluno não pode ser nulo.")
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
