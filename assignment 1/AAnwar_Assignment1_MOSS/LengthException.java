package exceptions;

/**
 * @throws RuntimeException
 */
public class LengthException extends RuntimeException{
    public LengthException()
    {
        super("The password must be at least 6 characters long");
    }
}
