package mauricio.syncfit.repositories;

import mauricio.syncfit.Domain.Aluno.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository  extends JpaRepository<Aluno, Integer> {
}
