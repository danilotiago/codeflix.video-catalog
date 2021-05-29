package app.projetaria.codeflixvideocatalog.exception;

import app.projetaria.codeflixvideocatalog.exception.error.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandleException {

    private static final String VALIDATION_ERROR = "Erro de validação";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> apply(MethodArgumentNotValidException ex) {
        ValidationError err = new ValidationError(LocalDateTime.now().toString(), HttpStatus.UNPROCESSABLE_ENTITY.value(), VALIDATION_ERROR);

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            err.addError(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
    }
}
