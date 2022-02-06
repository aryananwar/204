import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.InvalidSequenceException;
import exceptions.LengthException;
import exceptions.NoDigitException;
import exceptions.NoLowerAlphaException;
import exceptions.NoSpecialCharacterException;
import exceptions.NoUpperAlphaException;
import exceptions.UnmatchedException;
import exceptions.WeakPasswordException;

/*
 * @author aryan anwar
 */
public class PasswordCheckerUtility {

    /**
     * determines if password is valid based on methods
     * @param password
     * @return boolean
     * @throws LengthException
     * @throws NoUpperAlphaException
     * @throws NoDigitException
     * @throws NoLowerAlphaException
     * @throws InvalidSequenceException
     * @throws NoSpecialCharacterException
     */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
		NoDigitException, NoLowerAlphaException,  InvalidSequenceException, NoSpecialCharacterException  
	{

		if (isValidLength(password) == false)
			throw new LengthException();
		if (hasUpperAlpha(password) == false)
			throw new LengthException();
		if (hasLowerAlpha(password) == false)
			throw new NoLowerAlphaException();
		if(hasUpperAlpha(password) == false)
			throw new NoUpperAlphaException();
		if(hasDigit(password) == false)
			throw new NoDigitException();
		if(hasInvalidSequence(password) == false)
			throw new InvalidSequenceException();
		if(hasSpecialCharacter(password) == false)
			throw new NoSpecialCharacterException();

        return (isValidLength(password) && hasLowerAlpha(password) 
        		&&  hasUpperAlpha(password) &&  hasSpecialCharacter(password) 
        		&& hasDigit(password) && hasInvalidSequence(password));
    }

    /**
     * if password is valid and is less than than 10 characters password is weak
     * @param password
     * @return boolean
     * @throws WeakPasswordException
     */
    public static boolean isWeakPassword(String password) throws WeakPasswordException
    {
        boolean isValid = isValidPassword(password);
        if (isValid && password.length() < 10)
        {
        	 throw new WeakPasswordException();
        }
        return true;
       
    }

    /**
     *
     * @param password
     * @return boolean
     * @throws LengthException
     */
    public static boolean isValidLength(String password) throws LengthException
    {
        if (password.length() < 6)
            throw new LengthException();
        return true;

    }

    /**
     * determines if password has an uppercase character
     * @param password
     * @return boolean
     * @throws NoUpperAlphaException
     */
    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
    {
        for (int i=0; i <password.length(); i++)
        {
            if (Character.isUpperCase(password.charAt(i)))
                return true;
        }
        throw new NoUpperAlphaException();
    }

    /**
     * determines if password has lowercase character
     * @param password
     * @return boolean
     * @throws NoLowerAlphaException
     */
    public static boolean hasLowerAlpha (String password) throws NoLowerAlphaException
    {
        for (int i=0; i <password.length(); i++)
        {
            if (Character.isLowerCase(password.charAt(i)))
                return true;
        }
        throw new NoLowerAlphaException();
    }

    /**
     * determines if password has special character
     * @param password
     * @return
     * @throws NoSpecialCharacterException
     */
    public static boolean hasSpecialCharacter (String password) throws NoSpecialCharacterException
    {
    	  Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    	  Matcher m = p.matcher(password);
    	  if (m.find())
    		  return true;
    	  throw new NoSpecialCharacterException();
    }

    /**
     * determines if password contains  a digit
     * @param password
     * @return boolean
     * @throws NoDigitException
     */
    public static boolean hasDigit (String password) throws NoDigitException
    {
    	if (password.matches(".*\\d.*"))
    		return true; 
    	
        throw new NoDigitException();
    }

    /**
     * determines if password has 3 characters in a row
     * @param password
     * @return boolean
     * @throws InvalidSequenceException
     */
    public static boolean hasInvalidSequence(String password) throws InvalidSequenceException
    {
        for (int i =0; i <password.length(); i++)
        {
            try {
                if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i + 1) == password.charAt(i + 2)) {
                    throw new InvalidSequenceException();
                }
            }
            catch(IndexOutOfBoundsException e)
            {
                break;
            }
        }
        return true;
    }

    /**
     * determines if multiple passwords in arraylist are valid
     * @param arr
     * @return ArrayList
     */
    public static ArrayList<String> getInvalidPasswords(ArrayList<String> arr)
    {
    	ArrayList<String> status = new ArrayList<String>();
    	for (int i=0; i <arr.size(); i++)
    	{
    		try {
    			isValidPassword(arr.get(i));
    		}
    		catch(Exception e)
    		{
    			status.add(arr.get(i) + " -> " + e.getMessage());
    		}
    	}
    	return status;
    	
    }

    /**
     *
     * @param password1
     * @param password2
     * @return boolean
     */
	public static boolean comparePasswordsWithReturn(String password1, String password2){
		if (password1 != password2)
			return false;
		return true;
	}

    /**
     *
     * @param password1
     * @param password2
     * @throws UnmatchedException
     */
	public static void comparePasswords(String password1, String password2) throws UnmatchedException {
		if (password1 != password2)
			throw new UnmatchedException();
		
	}


}
