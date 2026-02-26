// ContratoOutputDto.java
package mauricio.syncfit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mauricio.syncfit.Domain.Contrato.EnumVigenciaContrato;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContratoOutputDto {
    private int vigencia;
    private EnumVigenciaContrato vigencia_unidade;
    private LocalDateTime dt_inicio;
    private LocalDate dt_final;
    private boolean ativo;
    private BigDecimal valor;
}