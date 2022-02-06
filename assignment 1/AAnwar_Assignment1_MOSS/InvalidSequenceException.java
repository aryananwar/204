package exceptions;


/**
 * @throws RuntimeException
 */
public class InvalidSequenceException extends RuntimeException{
    public InvalidSequenceException()
    {
        super("Password cannot contain more than 2 of the same character in sequence");
    }
}
