package com.elaine.projeto.atualizacao.controller;

import com.elaine.projeto.atualizacao.dto.AtendimentoDTO;
import com.elaine.projeto.atualizacao.service.AtendimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/atendimento")
@RequiredArgsConstructor
@RestController
public class AtendimentoController {

    private final AtendimentoService atendimentoService;

    @GetMapping
    public ResponseEntity buscar(){
        return ResponseEntity.ok(atendimentoService.findAll());

    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody AtendimentoDTO atendimentoDTO){
        return ResponseEntity.ok(atendimentoService.save(atendimentoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        atendimentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        return atendimentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
