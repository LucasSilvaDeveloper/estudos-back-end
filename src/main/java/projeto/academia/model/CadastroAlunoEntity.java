package projeto.academia.model;

import jakarta.persistence.*;
import projeto.academia.model.enums.StatusAlunoEnum;

import java.time.LocalDate;


@Entity
@Table(name = "alunos")
public class CadastroAlunoEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String nomeCompleto;

        @Column(nullable = false, unique = true)
        private String cpf;

        @Column(nullable = false, unique = true)
        private String email;

        private String telefone;

        private LocalDate dataNascimento;

        private Double altura;

        private Double peso;

        @Enumerated(EnumType.STRING)
        private StatusAlunoEnum status = StatusAlunoEnum.ATIVO;

        // Getters e setters

}
