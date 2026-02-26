package mauricio.syncfit.dto;

import jakarta.validation.constraints.NotBlank;
import mauricio.syncfit.Domain.Aluno.Aluno;
import mauricio.syncfit.Domain.Contrato.Contrato;
import mauricio.syncfit.Domain.Contrato.EnumVigenciaContrato;
import mauricio.syncfit.Domain.Plano.Plano;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ContratoInputDto(

@NotBlank(message = "Informar a vigencia do contrato.")
int vigencia,

@NotBlank(message = "Informar a unidade da vigencia.")
EnumVigenciaContrato vigencia_unidade,

@NotBlank(message = "Informar data de inicio do contrato.")
LocalDateTime dt_inicio,

@NotBlank(message = "Informar data de termino do contrato.")
LocalDate dt_final,

@NotBlank(message = "Informar se ativo.")
boolean ativo,
@NotBlank(message = "Informar o valor do contrato.")
BigDecimal valor
//
//@NotBlank(message = "Informar o plano.")
//int plano_id
){
    public Contrato toModel(Aluno aluno) {
        return new Contrato(vigencia, vigencia_unidade, dt_inicio, dt_final, true, valor, aluno);
    }
};
