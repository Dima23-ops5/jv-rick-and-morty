package mate.academy.rickandmorty.exception;

public class DaraProcessingException extends RuntimeException {
    public DaraProcessingException(String message, Throwable ex) {
        super(message, ex);
    }
}
