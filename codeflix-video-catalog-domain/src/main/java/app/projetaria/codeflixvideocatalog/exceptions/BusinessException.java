package app.projetaria.codeflixvideocatalog.exceptions;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Exception ex) {
        super(message, ex);
    }
}
