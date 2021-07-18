package app.projetaria.codeflixvideocatalog.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationError extends GenericError {

    private List<FieldMessageError> errors = new ArrayList<FieldMessageError>();

    public ValidationError(String timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public void addError(String field, String message) {
        this.errors.add(new FieldMessageError(field, message));
    }
}
