package mauricio.syncfit.Helper.CustomAnnotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import mauricio.syncfit.Helper.Validations.CPFValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CPFValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCPF {
    String message() default "CPF inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
