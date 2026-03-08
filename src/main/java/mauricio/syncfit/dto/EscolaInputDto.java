package mauricio.syncfit.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EscolaInputDto(
        @NotBlank(message = "Informar o nome.")
        String nome,

        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "Informar o endereco da escola.")
        String endereco
){}