package exceptions;
/**
 * @throws RuntimeException
 */
public class NoUpperAlphaException extends RuntimeException {
    public NoUpperAlphaException() {
        super("Password must contain at least one uppercase alphabetic character");
    }
}
