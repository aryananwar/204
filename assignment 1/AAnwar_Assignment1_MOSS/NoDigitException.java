package exceptions;

/**
 * @throws RuntimeException
 */
public class NoDigitException extends RuntimeException{
    public NoDigitException()
    {
        super("Password must contain at least one digit");
    }
}
