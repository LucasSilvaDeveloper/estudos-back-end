package projeto.academia.mapper;

import projeto.academia.dto.AlunoRequestDTO;
import projeto.academia.dto.AlunoResponseDTO;
import projeto.academia.model.CadastroAlunoEntity;

public class AlunoMapper {

    public static CadastroAlunoEntity toEntity(AlunoRequestDTO dto) {
        CadastroAlunoEntity aluno = new CadastroAlunoEntity();
        aluno.setNomeCompleto(dto.getNomeCompleto());
        aluno.setCpf(dto.getCpf());
        aluno.setEmail(dto.getEmail());
        aluno.setTelefone(dto.getTelefone());
        aluno.setDataNascimento(dto.getDataNascimento());
        aluno.setAltura(dto.getAltura());
        aluno.setPeso(dto.getPeso());
        // status será "ATIVO" por padrão na entidade
        return aluno;
    }

    public static AlunoResponseDTO toResponse(CadastroAlunoEntity entity) {
        AlunoResponseDTO dto = new AlunoResponseDTO();
        dto.setId(entity.getId());
        dto.setNomeCompleto(entity.getNomeCompleto());
        dto.setCpf(entity.getCpf());
        dto.setEmail(entity.getEmail());
        dto.setTelefone(entity.getTelefone());
        dto.setDataNascimento(entity.getDataNascimento());
        dto.setAltura(entity.getAltura());
        dto.setPeso(entity.getPeso());
        dto.setStatus(entity.getStatus().name()); // converte enum para String
        return dto;
    }

}
