package mauricio.syncfit.Mapper;

import mauricio.syncfit.Domain.Escola.Escola;
import mauricio.syncfit.dto.EscolaEditInputDto;
import mauricio.syncfit.dto.EscolaInputDto;
import mauricio.syncfit.dto.EscolaOutputDto;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = {PokemonMapper.class})
public interface EscolaMapper {
    Escola toModel(EscolaInputDto escola);
    Escola toModel(EscolaEditInputDto escola);
    EscolaOutputDto toOutput(Escola escola);
    List<EscolaOutputDto> toListOutput(List<Escola> escola);
}
