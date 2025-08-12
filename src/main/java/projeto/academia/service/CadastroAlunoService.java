package projeto.academia.service;

import org.springframework.stereotype.Service;
import projeto.academia.dto.AlunoRequestDTO;
import projeto.academia.dto.AlunoResponseDTO;
import projeto.academia.mapper.AlunoMapper;
import projeto.academia.model.CadastroAlunoEntity;
import projeto.academia.repository.AlunoRepository;

import java.util.List;

@Service
public class CadastroAlunoService {

    private final AlunoRepository alunoRepository;

    public CadastroAlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // Criar aluno
    public AlunoResponseDTO cadastrar(AlunoRequestDTO dto) {
        alunoRepository.findByCpf(dto.getCpf())
                .ifPresent(a -> {
                    throw new RuntimeException("Já existe um aluno com este CPF.");
                });

        CadastroAlunoEntity entity = AlunoMapper.toEntity(dto);
        CadastroAlunoEntity saved = alunoRepository.save(entity);
        return AlunoMapper.toResponse(saved);
    }

    // Listar todos
    public List<AlunoResponseDTO> listarTodos() {
        return alunoRepository.findAll()
                .stream()
                .map(AlunoMapper::toResponse)
                .toList();
    }

    // Buscar por ID
    public AlunoResponseDTO buscarPorId(Long id) {
        CadastroAlunoEntity entity = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return AlunoMapper.toResponse(entity);
    }

    // Atualizar (PUT - todos os campos)
    public AlunoResponseDTO atualizar(Long id, AlunoRequestDTO dto) {
        CadastroAlunoEntity entity = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        // Substitui todos os campos
        entity.setNomeCompleto(dto.getNomeCompleto());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setAltura(dto.getAltura());
        entity.setPeso(dto.getPeso());

        CadastroAlunoEntity updated = alunoRepository.save(entity);
        return AlunoMapper.toResponse(updated);
    }

    // Atualização parcial (PATCH)
    public AlunoResponseDTO atualizarParcial(Long id, AlunoRequestDTO dto) {
        CadastroAlunoEntity entity = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        // Só atualiza se o campo foi enviado
        if (dto.getNomeCompleto() != null) entity.setNomeCompleto(dto.getNomeCompleto());
        if (dto.getCpf() != null) entity.setCpf(dto.getCpf());
        if (dto.getEmail() != null) entity.setEmail(dto.getEmail());
        if (dto.getTelefone() != null) entity.setTelefone(dto.getTelefone());
        if (dto.getDataNascimento() != null) entity.setDataNascimento(dto.getDataNascimento());
        if (dto.getAltura() != null) entity.setAltura(dto.getAltura());
        if (dto.getPeso() != null) entity.setPeso(dto.getPeso());

        CadastroAlunoEntity updated = alunoRepository.save(entity);
        return AlunoMapper.toResponse(updated);
    }

    // Deletar
    public void deletar(Long id) {
        CadastroAlunoEntity entity = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        alunoRepository.delete(entity);
    }
}
