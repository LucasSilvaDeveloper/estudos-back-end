package projeto.academia.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;


public class AlunoRequestDTO {

    @NotBlank(message = "o nome é obrigatório")
    private String nomeCompleto;

    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;

    @Email(message = "E-mail inválido")
    @NotBlank(message =  "O E-mail é obrigatório")
    private String email;

    private String telefone;

    @Past(message = "a data de nascimento deve estar no passado")
    private LocalDate dataNascimento;

    @Positive(message = "A altura deve ser maior que zero")
    private Double altura;

    @Positive(message = "o peso deve ser maior que zero")
    private Double peso;

}
