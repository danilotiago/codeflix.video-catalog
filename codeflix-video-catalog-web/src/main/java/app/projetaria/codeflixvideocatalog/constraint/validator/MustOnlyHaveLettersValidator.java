package app.projetaria.codeflixvideocatalog.constraint.validator;

import app.projetaria.codeflixvideocatalog.constraint.annotation.MustOnlyHaveLetters;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MustOnlyHaveLettersValidator implements ConstraintValidator<MustOnlyHaveLetters, String> {

    @Override
    public void initialize(MustOnlyHaveLetters text) {
    }

    @Override
    public boolean isValid(String text, ConstraintValidatorContext cxt) {
        return ! text.matches(".*\\d.*");
    }
}
