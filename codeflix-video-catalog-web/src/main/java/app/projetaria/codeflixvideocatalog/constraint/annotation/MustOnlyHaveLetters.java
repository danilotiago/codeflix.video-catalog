package app.projetaria.codeflixvideocatalog.constraint.annotation;

import app.projetaria.codeflixvideocatalog.constraint.validator.MustOnlyHaveLettersValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = MustOnlyHaveLettersValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MustOnlyHaveLetters {

    String message() default "Deve ter apenas letras";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
