package mauricio.syncfit.dto;

public record EscolaEditInputDto(
        Long id,
        String nome,
        String email,
        String endereco
){}