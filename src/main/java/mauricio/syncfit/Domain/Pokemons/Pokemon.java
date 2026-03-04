package mauricio.syncfit.Domain.Pokemons;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mauricio.syncfit.Domain.Escola.Escola;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pokemons")
@Table(name = "pokemons")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "escola_id", nullable = false)
    private Escola escola;

}
