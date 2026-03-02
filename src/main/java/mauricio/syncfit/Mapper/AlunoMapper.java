// AlunoMapper.java
package mauricio.syncfit.Mapper;

import mauricio.syncfit.Domain.Aluno.Aluno;
import mauricio.syncfit.Domain.Contrato.Contrato;
import mauricio.syncfit.dto.AlunoOutputDto;
import mauricio.syncfit.dto.ContratoOutputDto;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface AlunoMapper {
    AlunoOutputDto toDTO(Optional<Aluno> aluno);
    ContratoOutputDto toContratoOutputDto(Contrato contrato);

    List<AlunoOutputDto> toDTO(List<Aluno> alunos);
}