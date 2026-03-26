package exceptions;

public class NetworkConnectionException extends RuntimeException {

    public NetworkConnectionException(String message) {
        super(message);
    }
}
