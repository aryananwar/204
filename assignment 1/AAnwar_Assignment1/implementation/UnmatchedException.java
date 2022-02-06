package exceptions;
/**
 * @throws RuntimeException
 */
public class UnmatchedException extends RuntimeException {
	public UnmatchedException()
	{
		super("Passwords do not match");
	}
}
