package exceptions;
/**
 * @throws RuntimeException
 */
public class WeakPasswordException extends RuntimeException{
    public WeakPasswordException()
    {
        super("Password is OK but weak, it contains fewer than 10 characters");
    }
}
