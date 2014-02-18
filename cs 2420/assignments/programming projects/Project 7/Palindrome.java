/*********************************************************** 
 * Programming Assignment 7
 * Palindrome program
 * Programmer: Mark Eatough and Paul English
 * Course: CS 2410 
 * Created March 6, 2013
 
 * This checks to see if a string is a palindrome, and
 * outputs a message so say if it is or not.
 ***********************************************************/
import java.util.ArrayList;

public class Palindrome
{
	//private fields
	private String word;
	private int index = 0;
	
	private Stack <Character> stack = new ListStack <Character>();
	private Queue <Character> queue = new ListQueue<Character>();
	
	//constructor
	public Palindrome(String anyString)
	{
		word = anyString;
	}
	
	//method to check if our word length is odd or even
	public static boolean isOdd (int k) 
	{ 
		return (k % 2) == 1; 
	} 

	
	public boolean isPalindrome()
	{	
		//set default result to true	
		boolean result = true;
		//use i to keep track of word length
		int i = word.length()/2;
		
		//add characters to stack starting from beginning of word
		while(index < i)
		{
			char s = word.charAt(index);
			s = Character.toLowerCase(s);
			stack.push(s);
			index++;
		}
		
		//check to see if length is odd
		if(isOdd(word.length()))
		{
			i++;	//if word length is odd increment i,
					//so we don't check the middle letter
		}
		
		//add characters to que starting from middle of word
		while(i < word.length())
		{
			char q = (word.charAt(i));
			q = Character.toLowerCase(q);
			queue.enqueue(q);
			i++;
		}
		
		//check to see if characters are equal
		while(stack.isEmpty() != true)
		{
			char s = stack.pop();
			char q = queue.dequeue();
			
			if(s != q)
			{
				result = false;
			}
		}
		return result;
	}


}//end palindrome class