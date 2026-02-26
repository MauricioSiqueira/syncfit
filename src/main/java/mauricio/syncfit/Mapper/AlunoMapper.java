// AlunoMapper.java
package mauricio.syncfit.Mapper;

import mauricio.syncfit.Domain.Aluno.Aluno;
import mauricio.syncfit.Domain.Contrato.Contrato;
import mauricio.syncfit.dto.AlunoOutputDto;
import mauricio.syncfit.dto.ContratoOutputDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    AlunoOutputDto toDTO(Aluno aluno);

    ContratoOutputDto toContratoOutputDto(Contrato contrato);
}