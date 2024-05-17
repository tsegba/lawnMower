package kata.lawnmower.domain.exception;

public class InvalidCommandException extends RuntimeException{
    public InvalidCommandException(final String errorMessage) {
        super(errorMessage);
    }
}
