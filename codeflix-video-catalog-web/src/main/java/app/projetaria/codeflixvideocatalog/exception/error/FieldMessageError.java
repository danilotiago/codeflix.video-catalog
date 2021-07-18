package app.projetaria.codeflixvideocatalog.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FieldMessageError {

    private String field;
    private String message;
}
