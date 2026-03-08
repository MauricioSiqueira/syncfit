package mauricio.syncfit.dto;

import jakarta.validation.constraints.*;
import mauricio.syncfit.Helper.CustomAnnotations.ValidCPF;

import java.time.LocalDate;

public record AlunoInputDto(
        @NotBlank(message = "A senha é obrigatória.")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d])\\S{8,16}$",
                message = "A senha deve ter entre 8 e 16 caracteres, incluindo maiúscula, minúscula, número e caractere especial."
        )
        String senha,

        @NotBlank(message = "CPF é obrigatório.")
        @ValidCPF(message = "CPF inválido.")
        String cpf,

        @NotBlank(message = "Informar o nome do aluno.")
        @Size(min = 3, max = 70, message = "O nome deve ter entre 3 e 50 caracteres.")
        String nome,

        @NotNull(message = "Informar a data de nascimento do aluno.")
        @Past(message = "A data de nascimento deve estar no passado.")
        LocalDate dt_nascimento
){
}
