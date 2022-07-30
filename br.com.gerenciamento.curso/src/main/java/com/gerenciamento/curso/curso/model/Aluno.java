package com.gerenciamento.curso.curso.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Aluno {

    @Id
    private Integer id;

    private String nome;

    private String email;

    private String gitHub;

}
