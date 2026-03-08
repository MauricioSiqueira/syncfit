package mauricio.syncfit.Mapper;

import mauricio.syncfit.Domain.Pokemons.Pokemon;
import mauricio.syncfit.dto.PokemonOutputDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PokemonMapper {
    PokemonOutputDto toOutput(Pokemon pokemon);
    List<PokemonOutputDto> toListOutput(List<Pokemon> pokemons);
}
