package projeto.academia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.academia.dto.AlunoRequestDTO;
import projeto.academia.dto.AlunoResponseDTO;
import projeto.academia.service.CadastroAlunoService;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class CadastroAlunoController {

    private final CadastroAlunoService cadastroAlunoService;

    public CadastroAlunoController(CadastroAlunoService cadastroAlunoService) {
        this.cadastroAlunoService = cadastroAlunoService;
    }

    // Criar aluno
    @PostMapping
    public ResponseEntity<AlunoResponseDTO> cadastrarAluno(@RequestBody AlunoRequestDTO dto) {
        AlunoResponseDTO response = cadastroAlunoService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Listar todos
    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(cadastroAlunoService.listarTodos());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cadastroAlunoService.buscarPorId(id));
    }

    // Atualizar (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> atualizar(@PathVariable Long id, @RequestBody AlunoRequestDTO dto) {
        return ResponseEntity.ok(cadastroAlunoService.atualizar(id, dto));
    }

    // Atualização parcial (PATCH)
    @PatchMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> atualizarParcial(@PathVariable Long id, @RequestBody AlunoRequestDTO dto) {
        return ResponseEntity.ok(cadastroAlunoService.atualizarParcial(id, dto));
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cadastroAlunoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}