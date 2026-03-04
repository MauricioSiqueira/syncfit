package mauricio.syncfit.dto;

import java.util.List;

public record EscolaOutputDto(
        Long id,
        String nome,
        String endereco,
        String email
){ }
