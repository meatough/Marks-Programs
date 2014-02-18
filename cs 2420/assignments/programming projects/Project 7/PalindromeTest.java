/*********************************************************** 
 * Programming Assignment 7
 * Palindrome program
 * Programmer: Mark Eatough
 * Course: CS 2410 
 * Created 
 * Modified 
 * Modified by Mark Eatough
 ***********************************************************/
import junit.framework.*;
import junit.extensions.*;

public class PalindromeTest
{
	

	public static TestSuite suite()
	{
		return new TestSuite(PalindromeTest.class);	
	}	
		
	public static void main (String[] args) 
	{
		String[] TestCaseName = {PalindromeTest.class.getName()};
		junit.textui.TestRunner.main(TestCaseName);
	}//end main method
}//end j-unit test class