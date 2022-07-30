package com.gerenciamento.curso.curso.model;

import com.gerenciamento.curso.curso.model.enums.DiaDaSemana;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
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

}
