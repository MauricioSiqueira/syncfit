package mauricio.syncfit.Domain.Aluno;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mauricio.syncfit.Domain.AlunoEscola.AlunoEscola;
import mauricio.syncfit.Domain.Pokemons.Pokemon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aluno", uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_aluno_cpf",
                columnNames = "cpf"
        )
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    public Aluno(String senha, String cpf, String nome, LocalDate dt_nascimento) {
        this.senha = senha;
        this.cpf = cpf;
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 16)
    private String senha;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, length = 70)
    private String nome;

    @Column(nullable = false)
    private LocalDate dt_nascimento;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    List<AlunoEscola> escolas = new ArrayList<>();
}