package mauricio.syncfit.repositories;

import mauricio.syncfit.Domain.Pokemons.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
}
