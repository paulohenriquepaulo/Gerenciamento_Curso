package com.gerenciamento.curso.curso.dto.aluno;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AlunoAtualizarDTO {

    @NotNull(message = "O id não pode ser nulo")
    private Integer id;

    @NotEmpty(message = "O nome não pode ser nulo ou vazio.")
    private String nome;

    @NotEmpty(message = "O e-mail não pode ser nulo ou vazio.")
    private String email;

    @NotEmpty(message = "O GitHub não pode ser nulo ou vazio.")
    private String gitHub;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGitHub() {
        return gitHub;
    }

    public void setGitHub(String gitHub) {
        this.gitHub = gitHub;
    }
}
