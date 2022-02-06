
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.InvalidSequenceException;
import exceptions.LengthException;
import exceptions.NoDigitException;
import exceptions.NoLowerAlphaException;
import exceptions.NoUpperAlphaException;
import exceptions.WeakPasswordException;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;
	String password1, password2;
	@Before
	public void setUp() throws Exception {
		String[] p = {"334455BB#", "george2ZZZ#", "4Sal#", "bertha22", "august30", "a2cDe", 
				"ApplesxxxYYzz#", "aa11Bb", "pilotProject", "AAAbb@123"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p)); 
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("aa"));
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("threw lengthExcepetion",true);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("aaaaaaaaaaaaaa"));
			 
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("threw NoUpperAlphaExcepetion",true);
		}

	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("AAAAAAAAAAA"));
 
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("threw NoLowerAlphaExcepetion",true);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			 
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("Aa123@");
			assertTrue("Did not throw WeakPassword Exception",false);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("threw a NoLowerAlphaExcepetion",true);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("234AAAAbsd!"));
		 	assertTrue("did not throw  InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("threw InvalidSequenceExcepetion",true);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("A@asdbcdefgh."));
		 	assertTrue("did not throw NoDigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("threw NoDigitException",true);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("A123abcdefg@."));
			assertTrue("Is valid password",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw a " + e + " exception",false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		Scanner scan = new Scanner(results.get(0)); 
		assertEquals(scan.next(), "334455BB#");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		
		scan = new Scanner(results.get(1));  
		assertEquals(scan.next(), "george2ZZZ#");
		nextResults = scan.nextLine().toLowerCase(); 
		assertTrue(nextResults.contains("sequence"));
		
		 
		scan = new Scanner(results.get(2));  
		assertEquals(scan.next(), "4Sal#");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("long"));
		
		scan = new Scanner(results.get(3));  
		assertEquals(scan.next(), "bertha22");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		
		scan = new Scanner(results.get(4));  
		assertEquals(scan.next(), "august30");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase") );
		
		 
		scan.close();

		
	}
	
}
