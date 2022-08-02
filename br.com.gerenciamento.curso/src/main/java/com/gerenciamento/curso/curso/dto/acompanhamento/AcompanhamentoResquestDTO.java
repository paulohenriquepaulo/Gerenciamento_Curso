package com.gerenciamento.curso.curso.dto.acompanhamento;

import com.gerenciamento.curso.curso.model.enums.DiaDaSemana;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

public class AcompanhamentoResquestDTO {

    @NotEmpty(message = "O E-mail do aluno não pode ser nulo.")
    private String email;

    @Enumerated(EnumType.STRING)
    private DiaDaSemana diaDaSemana;

    private Integer quantidadeAula;

    private String teveDificuldade;

    private String teveAtividadePratica;

    private String vaiPrecisarRefazerAula;

    private String aprendeu;

    private String comentario;

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
}
