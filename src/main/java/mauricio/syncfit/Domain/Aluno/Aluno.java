package mauricio.syncfit.Domain.Aluno;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mauricio.syncfit.Domain.Academia.Academia;
import mauricio.syncfit.Domain.Contrato.Contrato;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "alunos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "academia_id", nullable = false)
    private Academia academia;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Date dtNascimento;

    @OneToMany(mappedBy = "aluno", orphanRemoval = true)
    private List<Contrato> contratos = new ArrayList<>();
}