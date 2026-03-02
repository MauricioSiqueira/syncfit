package mauricio.syncfit.Mapper;

import mauricio.syncfit.Domain.Beneficio.Beneficio;
import mauricio.syncfit.Domain.Plano.Plano;
import mauricio.syncfit.dto.BeneficioInputDto;
import mauricio.syncfit.dto.PlanoInputDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlanoMapper {
    Plano toEntity(PlanoInputDto input);
    Beneficio toEntity(BeneficioInputDto input);
}
