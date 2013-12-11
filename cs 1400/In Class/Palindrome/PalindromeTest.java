import java.util.Scanner; 

public class PalindromeTest
{
	public static void main (String[] args)
	{
		Scanner input;
		input = new Scanner(System.in);

		System.out.print("enter a word ");
		String word = input.nextLine();
		
		
		Palindrome myPalindrome = new Palindrome(word);
		
		if (myPalindrome.isPalindrome())
		{
			System.out.printf("\n%s is a palindrome", word); 
		}
		else
		{
			System.out.printf("\n%s is not a palindrome", word);
		}
	}
}