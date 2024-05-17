package kata.lawnmower.domain.exception;

public class InvalidOrientationException extends RuntimeException{
    public InvalidOrientationException(final String errorMessage) {
        super(errorMessage);
    }
}
