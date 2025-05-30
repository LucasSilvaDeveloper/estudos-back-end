package com.elaine.projeto.atualizacao.dto;

import com.elaine.projeto.atualizacao.model.Atendimento;
import com.elaine.projeto.atualizacao.model.TipoAtendimento;

import java.time.LocalDateTime;

public record AtendimentoDTO(
        Long id,
        String nomeFisioterapeuta,
        String nomeAluno,
        TipoAtendimento tipoAtendimento,
        LocalDateTime dataAtendimento) {

    public Atendimento toAtendimento() {
        return Atendimento.builder()
                .nomeFisioterapeuta(nomeFisioterapeuta)
                .nomeAluno(nomeAluno)
                .build();
    }

    public static AtendimentoDTO from(Atendimento atendimento){
        return new AtendimentoDTO(
                atendimento.getId(),
                atendimento.getNomeFisioterapeuta(),
                atendimento.getNomeAluno(),
                atendimento.getTipoAtendimento(),
                atendimento.getDataAtendimento());
    }
}
