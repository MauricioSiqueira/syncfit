package mauricio.syncfit.Domain.Aluno;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mauricio.syncfit.Domain.Contrato.Contrato;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "alunos", uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_aluno_cpf",
                columnNames = "cpf"
        )
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 16)
    private String senha;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, length = 11)
    private String nome;

    @Column(nullable = false)
    private Date dtNascimento;

    /// Ligacoes entre tabelas
    @OneToMany(mappedBy = "aluno", orphanRemoval = true)
    private List<Contrato> contratos = new ArrayList<>();
}