package projeto.academia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import projeto.academia.model.CadastroAlunoEntity;
import projeto.academia.model.enums.StatusAlunoEnum;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<CadastroAlunoEntity, Long> {

    Optional<CadastroAlunoEntity> findByCpf(String cpf);
    Optional<CadastroAlunoEntity> findByEmail(String email);
    Page<CadastroAlunoEntity> findByStatus(StatusAlunoEnum status, Pageable pageable);
    Page<CadastroAlunoEntity> findByNomeCompletoContainingIgnoreCase(String nome, Pageable pageable);

}
