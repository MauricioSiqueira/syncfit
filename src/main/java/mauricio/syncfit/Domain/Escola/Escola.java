package mauricio.syncfit.Domain.Escola;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mauricio.syncfit.Domain.AlunoEscola.AlunoEscola;
import mauricio.syncfit.Domain.Pokemons.Pokemon;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "escolas")
@Table(name = "escolas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, length = 70)
    private String email;

    @Column(nullable = true, length = 255)
    private String endereco;

    @OneToMany(mappedBy = "escola", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Pokemon> pokemons = new ArrayList<>();


    @OneToMany(mappedBy = "escola", cascade = CascadeType.ALL, orphanRemoval = true)
    List<AlunoEscola> alunos = new ArrayList<>();
}
