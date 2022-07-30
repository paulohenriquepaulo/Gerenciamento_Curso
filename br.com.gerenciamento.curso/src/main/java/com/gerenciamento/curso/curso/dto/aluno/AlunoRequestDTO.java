package com.gerenciamento.curso.curso.dto.aluno;

import javax.validation.constraints.NotEmpty;

public class AlunoRequestDTO {

    @NotEmpty(message = "O nome não pode ser nulo ou vazio.")
    private String nome;

    @NotEmpty(message = "O e-mail não pode ser nulo ou vazio.")
    private String email;

    @NotEmpty(message = "O GitHub não pode ser nulo ou vazio.")
    private String gitHub;

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
