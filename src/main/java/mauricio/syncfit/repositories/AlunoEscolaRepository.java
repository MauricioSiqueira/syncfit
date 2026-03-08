package mauricio.syncfit.repositories;

import mauricio.syncfit.Domain.AlunoEscola.AlunoEscola;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoEscolaRepository extends JpaRepository<AlunoEscola, Integer> {
}
