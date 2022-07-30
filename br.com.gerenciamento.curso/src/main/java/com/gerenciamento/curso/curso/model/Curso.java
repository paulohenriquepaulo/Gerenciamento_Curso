package com.gerenciamento.curso.curso.model;

import com.gerenciamento.curso.curso.model.enus.Processo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
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


}
