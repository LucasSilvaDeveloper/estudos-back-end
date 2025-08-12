package projeto.academia.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoResponseDTO {

    private Long id;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private Double altura;
    private Double peso;
    private String status;

}
