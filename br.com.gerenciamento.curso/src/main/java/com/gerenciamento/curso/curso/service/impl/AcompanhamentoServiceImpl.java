package com.gerenciamento.curso.curso.service.impl;

import com.gerenciamento.curso.curso.mapper.AcompanhamentoMapper;
import com.gerenciamento.curso.curso.model.Acompanhamento;
import com.gerenciamento.curso.curso.model.Aluno;
import com.gerenciamento.curso.curso.model.enums.DiaDaSemana;
import com.gerenciamento.curso.curso.repository.AcompanhamentoRepository;
import com.gerenciamento.curso.curso.service.AcompanhamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class AcompanhamentoServiceImpl implements AcompanhamentoService {

    @Autowired
    private AcompanhamentoRepository  acompanhamentoRepository;

    @Autowired
    private AlunoServiceImpl alunoService;

    @Autowired
    private AcompanhamentoMapper acompanhamentoMapper;

    @Override
    public Acompanhamento registrarAcompanhamento(Acompanhamento dto) {
        Aluno aluno = alunoService.buscarAlunoPorEmail(dto.getAluno().getEmail());
        Acompanhamento acompanhamento = acompanhamentoMapper.toAcompanhamento(dto);
        acompanhamento.setAluno(aluno);
        acompanhamento.setTeveDificuldade(dto.getTeveDificuldade().toUpperCase());
        acompanhamento.setVaiPrecisarRefazerAula(dto.getVaiPrecisarRefazerAula().toUpperCase());
        acompanhamento.setTeveAtividadePratica(dto.getTeveAtividadePratica().toUpperCase());
        acompanhamento.setDiaDaSemana(validarDiaDaSemana(dto.getDiaDaSemana()));
        return acompanhamentoRepository.save(acompanhamento);
    }

    private DiaDaSemana validarDiaDaSemana(DiaDaSemana diaDaSemana) {
        if (diaDaSemana == null) {
            Calendar calendar = Calendar.getInstance();
            int dia = calendar.get(Calendar.DAY_OF_WEEK);
            switch (dia) {
                case 1:
                    diaDaSemana = DiaDaSemana.DOMINGO;
                    break;
                case 2:
                    diaDaSemana = DiaDaSemana.SEGUNDA;
                    break;
                case 3:
                    diaDaSemana = DiaDaSemana.TERÇA;
                    break;
                case 4:
                    diaDaSemana = DiaDaSemana.QUARTA;
                    break;
                case 5:
                    diaDaSemana = DiaDaSemana.QUINTA;
                    break;
                case 6:
                    diaDaSemana = DiaDaSemana.SEXTA;
                    break;
                case 7:
                    diaDaSemana = DiaDaSemana.SÁBADO;
                    break;
            }
        }
        return diaDaSemana;
    }
}
