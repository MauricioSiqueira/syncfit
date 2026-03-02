package mauricio.syncfit.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import mauricio.syncfit.Domain.Beneficio.Beneficio;
import mauricio.syncfit.Domain.Plano.Plano;

import java.util.List;

public record PlanoInputDto(

        @NotBlank(message = "Informar o nome do plano.")
        @Size(max = 70, message = "Nome deve ter no máximo 100 caracteres")
        String nome,

        @NotNull(message = "Informar se ativo.")
        Boolean ativo,

        List<BeneficioInputDto> beneficios
){
};