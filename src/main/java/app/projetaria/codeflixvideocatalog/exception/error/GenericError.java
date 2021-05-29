package app.projetaria.codeflixvideocatalog.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericError {

    private String timestamp;
    private Integer status;
    private String error;
}
