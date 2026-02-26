package mauricio.syncfit.dto;

import jakarta.validation.constraints.NotBlank;
import mauricio.syncfit.Domain.Aluno.Aluno;
import mauricio.syncfit.Domain.Contrato.Contrato;

import java.time.LocalDate;
import java.util.List;

public record AlunoInputDto(
        @NotBlank(message = "Informar Senha.")
        String senha,

        @NotBlank(message = "Informar CPF.")
        String cpf,

        @NotBlank(message = "Informar o nome do aluno.")
        String nome,

        @NotBlank(message = "Informar a data de nascimento do aluno.")
        LocalDate dt_nascimento,

        List<ContratoInputDto> contratos
){
        public Aluno toModel() {
                var aluno = new Aluno(nome, cpf, senha, dt_nascimento);

                List<Contrato> listaContratos = contratos.stream()
                        .map(c -> c.toModel(aluno))
                        .toList();

                aluno.setContratos(listaContratos);
                return aluno;
        }
};
