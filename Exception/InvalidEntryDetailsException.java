package Exception;

public class InvalidEntryDetailsException extends RuntimeException{
    public InvalidEntryDetailsException() {
    }

    public InvalidEntryDetailsException(String message) {
        super(message);
    }
}
