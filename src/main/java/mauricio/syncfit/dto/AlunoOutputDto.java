// AlunoOutputDto.java
package mauricio.syncfit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlunoOutputDto {
    private String cpf;
    private String nome;
    private LocalDate dt_nascimento;
    private List<ContratoOutputDto> contratos;
}