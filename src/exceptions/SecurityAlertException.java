package exceptions;

public class SecurityAlertException extends RuntimeException {

    public SecurityAlertException(String message) {
        super(message);
    }
}
