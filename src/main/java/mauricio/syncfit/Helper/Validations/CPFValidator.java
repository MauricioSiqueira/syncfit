package mauricio.syncfit.Helper.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import mauricio.syncfit.Helper.CustomAnnotations.ValidCPF;

public class CPFValidator implements ConstraintValidator<ValidCPF, String> {

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (cpf == null || cpf.isBlank()) return false;

        // Remove pontuação
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) return false;

        // Rejeita sequências iguais (ex: 111.111.111-11)
        if (cpf.chars().distinct().count() == 1) return false;

        return validarDigitos(cpf);
    }

    private boolean validarDigitos(String cpf) {
        int[] nums = cpf.chars().map(c -> c - '0').toArray();

        // Valida 1º dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) soma += nums[i] * (10 - i);
        int dig1 = (soma * 10) % 11;
        if (dig1 == 10) dig1 = 0;
        if (dig1 != nums[9]) return false;

        // Valida 2º dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) soma += nums[i] * (11 - i);
        int dig2 = (soma * 10) % 11;
        if (dig2 == 10) dig2 = 0;
        return dig2 == nums[10];
    }
}
