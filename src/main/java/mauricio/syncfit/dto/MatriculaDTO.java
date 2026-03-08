package mauricio.syncfit.dto;

import jakarta.validation.constraints.NotBlank;

public record MatriculaDTO(
        @NotBlank(message = "Informar escola")
        long EscolaId,

        @NotBlank(message = "Informar Aluno")
        int AlunoId
) {
}
