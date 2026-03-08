package mauricio.syncfit.Domain.AlunoEscola;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mauricio.syncfit.Domain.Aluno.Aluno;
import mauricio.syncfit.Domain.Escola.Escola;

import java.lang.reflect.Constructor;

@Entity(name = "alunoescola")
@Table(name = "alunosescolas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoEscola {

    public AlunoEscola(Aluno aluno, Escola escola) {
        this.aluno = aluno;
        this.escola = escola;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "escola_id", nullable = false)
    private Escola escola;
}
