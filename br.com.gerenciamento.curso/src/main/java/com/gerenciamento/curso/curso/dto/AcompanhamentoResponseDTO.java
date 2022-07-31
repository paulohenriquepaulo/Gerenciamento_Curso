package com.gerenciamento.curso.curso.dto;

import com.gerenciamento.curso.curso.model.enums.DiaDaSemana;

public class AcompanhamentoResponseDTO {

    private Integer id_acompanhamento;

    private String email;

    private String nomeAluno;

    private DiaDaSemana diaDaSemana;

    private Integer quantidadeAula;

    private String teveDificuldade;

    private String teveAtividadePratica;

    private String vaiPrecisarRefazerAula;

    private String aprendeu;

    private String comentario;


    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DiaDaSemana getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public Integer getQuantidadeAula() {
        return quantidadeAula;
    }

    public void setQuantidadeAula(Integer quantidadeAula) {
        this.quantidadeAula = quantidadeAula;
    }

    public String getTeveDificuldade() {
        return teveDificuldade;
    }

    public void setTeveDificuldade(String teveDificuldade) {
        this.teveDificuldade = teveDificuldade;
    }

    public String getTeveAtividadePratica() {
        return teveAtividadePratica;
    }

    public void setTeveAtividadePratica(String teveAtividadePratica) {
        this.teveAtividadePratica = teveAtividadePratica;
    }

    public String getVaiPrecisarRefazerAula() {
        return vaiPrecisarRefazerAula;
    }

    public void setVaiPrecisarRefazerAula(String vaiPrecisarRefazerAula) {
        this.vaiPrecisarRefazerAula = vaiPrecisarRefazerAula;
    }

    public String getAprendeu() {
        return aprendeu;
    }

    public void setAprendeu(String aprendeu) {
        this.aprendeu = aprendeu;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getId_acompanhamento() {
        return id_acompanhamento;
    }

    public void setId_acompanhamento(Integer id_acompanhamento) {
        this.id_acompanhamento = id_acompanhamento;
    }
}
