package projeto.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.academia.model.CadastroAlunoEntity;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<CadastroAlunoEntity, Long> {

    Optional<CadastroAlunoEntity> findByCpf(String cpf);


}
