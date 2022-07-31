package com.gerenciamento.curso.curso.model;

import com.gerenciamento.curso.curso.model.enums.DiaDaSemana;

import javax.persistence.*;

@Entity
public class Acompanhamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private DiaDaSemana diaDaSemana;

    private Integer quantidadeAula;

    private String teveDificuldade;

    private String teveAtividadePratica;

    private String vaiPrecisarRefazerAula;

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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
