package kata.lawnmower.app.exception;

public class FileNotFoundException extends Exception{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 7950403806253174707L;

    public FileNotFoundException(String message) {
        super(message);
    }
}
