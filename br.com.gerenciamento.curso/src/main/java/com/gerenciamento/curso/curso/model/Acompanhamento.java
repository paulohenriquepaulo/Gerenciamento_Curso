package com.gerenciamento.curso.curso.model;

import com.gerenciamento.curso.curso.model.enums.DiaDaSemana;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Acompanhamento {

    @Id
    private Integer id;

    private DiaDaSemana diaDaSemana;

    private Integer quantidadeAula;

    private Boolean  teveDificuldade;

    private Boolean teveAtividadePratica;

    private Boolean vaiPrecisarRefazerAula;

    private String aprendeu;

    private String comentario;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getTeveDificuldade() {
        return teveDificuldade;
    }

    public void setTeveDificuldade(Boolean teveDificuldade) {
        this.teveDificuldade = teveDificuldade;
    }

    public Boolean getTeveAtividadePratica() {
        return teveAtividadePratica;
    }

    public void setTeveAtividadePratica(Boolean teveAtividadePratica) {
        this.teveAtividadePratica = teveAtividadePratica;
    }

    public Boolean getVaiPrecisarRefazerAula() {
        return vaiPrecisarRefazerAula;
    }

    public void setVaiPrecisarRefazerAula(Boolean vaiPrecisarRefazerAula) {
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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
