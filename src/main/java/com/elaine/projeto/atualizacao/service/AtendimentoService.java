package com.elaine.projeto.atualizacao.service;

import com.elaine.projeto.atualizacao.dto.AtendimentoDTO;
import com.elaine.projeto.atualizacao.model.Atendimento;
import com.elaine.projeto.atualizacao.repository.AtendimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;

    public AtendimentoDTO save(AtendimentoDTO atendimentoDTO){
        Atendimento atendimento = atendimentoRepository.save(atendimentoDTO.toAtendimento());
        return AtendimentoDTO.from(atendimento);
    }

    public List<AtendimentoDTO> findAll() {
        return atendimentoRepository.findAll().stream().map(AtendimentoDTO::from).collect(Collectors.toList());
    }

    public void delete(Long id) {
        if (!atendimentoRepository.existsById(id)) {
            throw new IllegalArgumentException("Atendimento com ID " + id + " não encontrado.");
        }
        atendimentoRepository.deleteById(id);
    }


    public Optional<AtendimentoDTO> findById(Long id) {
        return atendimentoRepository.findById(id)
                .map(AtendimentoDTO::from);
    }
}
